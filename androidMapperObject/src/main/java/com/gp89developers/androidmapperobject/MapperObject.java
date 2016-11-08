package com.gp89developers.androidmapperobject;

import com.gp89developers.androidmapperobject.cache.MapperCache;
import com.gp89developers.androidmapperobject.utils.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by gabriel on 2/27/2016.
 */
public class MapperObject implements Mapper {
    private static MapperObject instance = null;
    private MapperCache<Class, List> mapperCache;

    public static MapperObject getInstance() {
        if (instance == null)
            instance = new MapperObject();

        return instance;
    }

    private MapperObject() {
        mapperCache = new MapperCache<>();
    }

    @Override
    public <T> T map(Object source, T destination) {

        try {

            if (source == null || destination == null)
                return null;

            List<Field> sourceFields = CollectionUtils.isEmpty(mapperCache.get(source.getClass())) ?
                    getAllDeclaredField(source.getClass()) : mapperCache.get(source.getClass());

            List<Field> destinationFields = CollectionUtils.isEmpty(mapperCache.get(destination.getClass())) ?
                    getAllDeclaredField(destination.getClass()) : mapperCache.get(destination.getClass());

            List<Field> fieldsClassAnnotation =
                    source.getClass().isAnnotationPresent(EntityMapper.class) ? sourceFields : destinationFields;

            for (Field field : fieldsClassAnnotation) {

                if (field.isAnnotationPresent(BackReference.class))
                    continue;

                if (!field.isAnnotationPresent(Mapping.class))
                    continue;

                Mapping mapping = field.getAnnotation(Mapping.class);
                String fieldName = !mapping.name().equals("") ? mapping.name() : field.getName();

                Field fromField = findFieldByName(sourceFields, fieldName);
                Field toField = findFieldByName(destinationFields, fieldName);

                if (toField == null || fromField == null)
                    continue;

                toField.setAccessible(true);
                fromField.setAccessible(true);

                boolean isEqualType = !mapping.otherType();
                boolean isIterable = !fromField.getType().isPrimitive() && (fromField.get(source) instanceof Collection); //Class.forName(fromField.getType().getName()).equals(List.class)
                boolean isOtherType = !isEqualType && !isIterable;
                boolean isInvalidField = fromField.get(source) == null || Modifier.isFinal(fromField.getModifiers());

                if (isInvalidField)
                    continue;

                if (isEqualType) {
                    toField.set(destination, fromField.get(source));

                } else if (isIterable) {
                    ParameterizedType type = (ParameterizedType) toField.getGenericType();
                    Class<?> toFieldClass = getClassByType(type);
                    Collection<Object> toFieldCollection = new ArrayList<>();

                    for (Object fromFieldValue : (Collection) fromField.get(source)) {
                        toFieldCollection.add(map(fromFieldValue, toFieldClass));
                    }

                    toField.set(destination, toFieldCollection);

                } else if (isOtherType) {
                    Object value = map(fromField.get(source), toField.getType());
                    toField.set(destination, value);
                }

            }

            return destination;
        } catch (IllegalAccessException e) {
            //TODO: manejar excepcion IllegalAccessException
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T map(Object source, Class<T> destinationClass) {
        try {
            return map(source, destinationClass.newInstance());
        } catch (InstantiationException e) {
            //TODO: manejar excepcion InstantiationException
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //TODO: manejar excepcion IllegalAccessException
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public <T> List<T> map(Collection<?> source, Class<T> destinationClass) {
        List<T> destination = new ArrayList<>();

        for (Object object : source) {
            destination.add(map(object, destinationClass));
        }

        return destination;
    }

    /**
     * this method get all field.
     *
     * @param clazz
     * @return field list
     */
    private List<Field> getAllDeclaredField(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();

        Class<?> typeClazz = clazz;
        while (typeClazz != null && typeClazz != Object.class) {
            fields.addAll(Arrays.asList(typeClazz.getDeclaredFields()));
            typeClazz = typeClazz.getSuperclass();
        }

        mapperCache.put(clazz, fields);
        return fields;
    }

    /**
     * find field by name
     *
     * @param fields
     * @param fieldName
     * @return
     */
    private Field findFieldByName(List<Field> fields, String fieldName) {
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            } else {
                if (field.isAnnotationPresent(Mapping.class)) {
                    Mapping mapping = field.getAnnotation(Mapping.class);
                    if (mapping == null || mapping.name().equals(""))
                        continue;
                    if (mapping.name().equals(fieldName))
                        return field;
                }
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> getClassByType(ParameterizedType parameterizedType) {
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
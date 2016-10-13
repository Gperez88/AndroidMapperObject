package com.gp89developers.androidmapperobject;

import java.util.Collection;
import java.util.List;

/**
 * Created by gaperez on 4/29/2016.
 */
public interface Mapper {
    public <T> T map(Object source, T destination);

    public <T> T map(Object source, Class<T> destinationClass);

    public <T> List<T> map(Collection<?> source, Class<T> destinationClass);

}

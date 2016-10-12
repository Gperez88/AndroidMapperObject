package com.gp89developers.androidmapperobject.cache;

/**
 * Created by gaperez on 4/27/2016.
 */
public interface Cache<KeyType, ValueType> {

    void clear();

    void put(KeyType key, ValueType value);

    ValueType get(KeyType key);

    long getSize();

    long getMaxSize();

    boolean containsKey(KeyType key);

}
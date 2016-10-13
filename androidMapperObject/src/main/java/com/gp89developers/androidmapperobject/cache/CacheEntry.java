package com.gp89developers.androidmapperobject.cache;

/**
 * Created by gaperez on 4/27/2016.
 */
public class CacheEntry<KeyType, ValueType> {
    private final KeyType key;
    private final ValueType value;

    public CacheEntry(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if ((this == object)) {
            return true;
        }
        if (!(object instanceof CacheEntry)) {
            return false;
        }
        CacheEntry entry = (CacheEntry) object;
        return this.getKey().equals(entry.getKey());
    }
}

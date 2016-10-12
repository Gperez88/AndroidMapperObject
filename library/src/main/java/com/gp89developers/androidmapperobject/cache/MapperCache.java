package com.gp89developers.androidmapperobject.cache;

import com.gp89developers.androidmapperobject.GlobalSettings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by gaperez on 4/26/2016.
 */
public class MapperCache<KeyType, ValueType> implements Cache<KeyType, ValueType> {
    private final LRUMap cacheMap;

    public MapperCache() {
        this.cacheMap = new LRUMap(GlobalSettings.getInstance().getCacheSize());
    }

    @Override
    public void clear() {
        cacheMap.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized void put(KeyType key, ValueType value) {
        if (key == null) {
            throw new IllegalArgumentException("Cache entry key cannot be null");
        }
        CacheEntry<KeyType, ValueType> cacheEntry = new CacheEntry(key, value);
        cacheMap.put(cacheEntry.getKey(), cacheEntry);
    }

    @Override
    public ValueType get(KeyType key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        CacheEntry<KeyType, ValueType> result = cacheMap.get(key);

        if (result != null) {
            return result.getValue();
        }

        return null;
    }

    @Override
    public long getSize() {
        return cacheMap.size();
    }

    @Override
    public long getMaxSize() {
        return cacheMap.maximumSize;
    }

    @Override
    public boolean containsKey(KeyType key) {
        return cacheMap.containsKey(key);
    }

    class LRUMap extends LinkedHashMap<KeyType, CacheEntry<KeyType, ValueType>> {

        private int maximumSize;

        LRUMap(int maximumSize) {
            this.maximumSize = maximumSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<KeyType, CacheEntry<KeyType, ValueType>> eldest) {
            return size() > maximumSize;
        }

    }
}

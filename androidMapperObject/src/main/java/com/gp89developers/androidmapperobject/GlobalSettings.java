package com.gp89developers.androidmapperobject;

/**
 * Created by gaperez on 5/3/2016.
 */
public class GlobalSettings {
    private static GlobalSettings instance = null;

    private int cacheSize = DefaultSettings.DEFAULT_CACHE_SIZE;


    public static GlobalSettings getInstance() {
        if (instance == null)
            instance = new GlobalSettings();

        return instance;
    }

    private GlobalSettings() {
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        if (cacheSize < 1) {
            throw new IllegalArgumentException("cache max size must be greater than 0");
        }

        this.cacheSize = cacheSize;
    }
}

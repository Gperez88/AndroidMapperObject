package com.gp89developers.androidmapperobject.utils;

import java.util.Collection;

/**
 * Created by gaperez on 4/28/2016.
 */
public class CollectionUtils {

    /**
     * Null-safe check if the specified collection is empty.
     * <p/>
     * Null returns true.
     *
     * @param coll the collection to check, may be null
     * @return true if empty or null
     * @since Commons Collections 3.2
     */
    public static boolean isEmpty(Collection coll) {
        return (coll == null || coll.isEmpty());
    }
}

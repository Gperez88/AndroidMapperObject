package com.gp89developers.androidmapperobject;

import java.util.List;

/**
 * Created by Guil on 5/7/2016.
 */
public interface Parsable<D, V extends Parsable> {

    public D parse();

    public V load(D domain);

    public List<V> convertViewList(List<D> domainList);

    public List<D> convertDomainList(List<V> viewList);
}

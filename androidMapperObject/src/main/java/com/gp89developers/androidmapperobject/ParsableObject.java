package com.gp89developers.androidmapperobject;

import java.util.List;

/**
 * Created by Guil on 5/7/2016.
 */
public abstract class ParsableObject<D, V extends Parsable> implements Parsable<D, V> {

    private Mapper mapper = MapperObject.getInstance();

    @Override
    public D parse() {
        return mapper.map(this, getDomainClass());
    }

    @SuppressWarnings("unchecked")
    @Override
    public V load(D domain) {
        return (V) mapper.map(domain, this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<V> convertViewList(List<D> domainList) {
        return (List<V>) mapper.map(domainList, getClass());
    }

    @Override
    public List<D> convertDomainList(List<V> viewList) {
        return (List<D>) mapper.map(viewList, getDomainClass());
    }

    public abstract Class<D> getDomainClass();
}
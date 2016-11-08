package com.gp89developers.androidmapperobject.entity;

import com.gp89developers.androidmapperobject.BackReference;
import com.gp89developers.androidmapperobject.Mapping;

/**
 * Created by gperez on 11/7/2016.
 */
public class ChildrenEntity {
    @Mapping
    private int id;
    @Mapping
    private String name;
    @BackReference
    @Mapping(otherType = true)
    private ParentEntity parent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentEntity getParent() {
        return parent;
    }

    public void setParent(ParentEntity parent) {
        this.parent = parent;
    }
}

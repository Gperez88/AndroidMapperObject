package com.gp89developers.androidmapperobject.entity;

/**
 * Created by gperez on 11/7/2016.
 */
public class ChildrenEntity {
    private int id;
    private String name;
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

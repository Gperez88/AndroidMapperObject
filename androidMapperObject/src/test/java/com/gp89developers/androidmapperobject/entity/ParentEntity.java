package com.gp89developers.androidmapperobject.entity;

import com.gp89developers.androidmapperobject.Mapping;

import java.util.List;

/**
 * Created by gperez on 11/7/2016.
 */

public class ParentEntity {
    @Mapping
    private int id;
    @Mapping
    private String name;
    @Mapping
    private List<ChildrenEntity> childrens;

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

    public List<ChildrenEntity> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<ChildrenEntity> childrenEntities) {
        this.childrens = childrenEntities;
    }
}

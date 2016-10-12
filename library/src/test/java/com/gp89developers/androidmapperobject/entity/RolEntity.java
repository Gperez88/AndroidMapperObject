package com.gp89developers.androidmapperobject.entity;

/**
 * Created by gaperez on 4/29/2016.
 */
public class RolEntity {
    private int id;
    private String name;

    public RolEntity() {
    }

    public RolEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}

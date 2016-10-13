package com.gp89developers.androidmapperobject.entity;

import java.util.List;

/**
 * Created by gaperez on 4/29/2016.
 */
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private PersonEntity person;
    private List<RolEntity> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public List<RolEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolEntity> roles) {
        this.roles = roles;
    }
}

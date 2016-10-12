package com.gp89developers.androidmapperobject.dto;

import com.gp89developers.androidmapperobject.EntityMapper;
import com.gp89developers.androidmapperobject.Mapping;
import com.gp89developers.androidmapperobject.ParsableObject;
import com.gp89developers.androidmapperobject.entity.UserEntity;

import java.util.List;

/**
 * Created by gaperez on 4/29/2016.
 */

@EntityMapper
public class UserDTO extends ParsableObject<UserEntity,UserDTO>{
    @Mapping
    private int id;
    @Mapping
    private String username;
    @Mapping
    private String password;
    @Mapping(otherType = true)
    private PersonDTO person;
    @Mapping(name = "roles", otherType = true)
    private List<RolDTO> roleDTOs;

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

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public List<RolDTO> getRoleDTOs() {
        return roleDTOs;
    }

    public void setRoleDTOs(List<RolDTO> roleDTOs) {
        this.roleDTOs = roleDTOs;
    }

    @Override
    public Class<UserEntity> getDomainClass() {
        return UserEntity.class;
    }
}

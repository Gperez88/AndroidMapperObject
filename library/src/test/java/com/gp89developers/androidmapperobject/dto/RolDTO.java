package com.gp89developers.androidmapperobject.dto;

import com.gp89developers.androidmapperobject.EntityMapper;
import com.gp89developers.androidmapperobject.Mapping;
import com.gp89developers.androidmapperobject.ParsableObject;
import com.gp89developers.androidmapperobject.entity.RolEntity;

/**
 * Created by gaperez on 4/29/2016.
 */

@EntityMapper
public class RolDTO extends ParsableObject<RolEntity, RolDTO> {
    @Mapping
    private int id;
    @Mapping(name = "name")
    private String rolName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Override
    public Class<RolEntity> getDomainClass() {
        return RolEntity.class;
    }
}

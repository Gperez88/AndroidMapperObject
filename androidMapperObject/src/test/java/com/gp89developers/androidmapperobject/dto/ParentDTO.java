package com.gp89developers.androidmapperobject.dto;

import com.gp89developers.androidmapperobject.EntityMapper;
import com.gp89developers.androidmapperobject.Mapping;
import com.gp89developers.androidmapperobject.ParsableObject;
import com.gp89developers.androidmapperobject.entity.ParentEntity;

import java.util.List;

/**
 * Created by gperez on 11/7/2016.
 */

@EntityMapper
public class ParentDTO extends ParsableObject<ParentEntity, ParentDTO> {
    @Mapping
    private int id;
    @Mapping
    private String name;
    @Mapping(otherType = true)
    private List<ChildrenDTO> childrens;

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

    public List<ChildrenDTO> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<ChildrenDTO> childrens) {
        this.childrens = childrens;
    }

    @Override
    public Class<ParentEntity> getDomainClass() {
        return ParentEntity.class;
    }
}

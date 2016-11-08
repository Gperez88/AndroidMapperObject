package com.gp89developers.androidmapperobject.dto;

import com.gp89developers.androidmapperobject.BackReference;
import com.gp89developers.androidmapperobject.EntityMapper;
import com.gp89developers.androidmapperobject.Mapping;
import com.gp89developers.androidmapperobject.ParsableObject;
import com.gp89developers.androidmapperobject.entity.ChildrenEntity;

/**
 * Created by gperez on 11/7/2016.
 */

@EntityMapper
public class ChildrenDTO extends ParsableObject<ChildrenEntity, ChildrenDTO> {
    @Mapping
    private int id;
    @Mapping
    private String name;
    @BackReference
    @Mapping(otherType = true)
    private ParentDTO parent;

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

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    @Override
    public Class<ChildrenEntity> getDomainClass() {
        return ChildrenEntity.class;
    }
}

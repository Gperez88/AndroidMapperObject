package com.gp89developers.androidmapperobject;

import com.gp89developers.androidmapperobject.dto.RolDTO;
import com.gp89developers.androidmapperobject.dto.UserDTO;
import com.gp89developers.androidmapperobject.entity.RolEntity;
import com.gp89developers.androidmapperobject.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaperez on 4/29/2016.
 */

public class MapperTest {

    @Before
    public void setUp() {
        //set size cache mapper.
        GlobalSettings.getInstance().setCacheSize(20_000);
    }


    @Test
    public void mapperObjectTest() {
        UserEntity userEntity = TestUtils.createUserEntity();

        //Entity to DTO - Using MapperObject
        Mapper mapperObject = MapperObject.getInstance();
        UserDTO mapperObjectUserDTO = mapperObject.map(userEntity, UserDTO.class);

        //DTO to Entity - using method extends ParseableObejct
        userEntity = mapperObjectUserDTO.parse();

        TestUtils.userDataAssertEquals(userEntity, mapperObjectUserDTO);
    }

    @Test
    public void mapperObjectCollectionTest() {
        List<RolEntity> roles = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            roles.add(new RolEntity(i, "Rol " + i));
        }

        //Entity to DTO - Using MapperObject
        Mapper mapperObject = MapperObject.getInstance();
        List<RolDTO> roleDTOs = mapperObject.map(roles, RolDTO.class);

        //DTO to Entity - using method extends ParseableObejct
        roles = new RolDTO().convertDomainList(roleDTOs);

        TestUtils.rolesDataAssertEquals(roles, roleDTOs);
    }
}

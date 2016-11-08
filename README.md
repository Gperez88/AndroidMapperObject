# AndroidMapperObject

  [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidMapperObject-green.svg?style=true)](https://android-arsenal.com/details/1/4536)

AndroidMapperObject is an extension the library [MapperObject](https://github.com/Gperez88/MapperObject) which it is a library that allows you to transfer data between two objects.

It support's : 
  - Object to Object data transfer
  - Collection to Collection data transfer
  - Break circular reference
  
### Usage

#### Add the dependencies to your gradle file:
```java
dependencies {
      compile 'com.github.gperez88:androidMapperObject:0.1.2'
}
```

It have two main annotations :
#### At the class level
```java
@EntityMapper
```
#### At the fields level
the mapping annotation
```java
@Mapping(name = "roles", otherType = true)
//name is is the field name on the other class
// otherType tells the mapper engine that this field has another mappins inside it.
```
the break circular reference annotation
```java
@BackReference
```

if you need to transfer the data in this class to another one
```java
public class UserEntity {
    private int id;
    private String username;
    private String password;
    //getters and setters
}
```
Extend the ParseableObject class like so :
```java
@EntityMapper
public class UserDTO extends ParsableObject<UserEntity,UserDTO>{
    @Mapping
    private int id;
    @Mapping
    private String username;
    @Mapping
    private String password;
    
    public UserDTO(){}
    
    //load the entity object
    public UserDTO(UserEntity userEntity){
      load(userEntity);
    }
    
    //getters and setters
}
```
#### Object to Object data transfer
transfer data the Entity to DTO
```java
UserDTO mapperObjectUserDTO = new UserDTO(userEntity);
```

also you can use the instance of MapperObject
```java
Mapper mapperObject = MapperObject.getInstance();
UserDTO mapperObjectUserDTO = mapperObject.map(userEntity, UserDTO.class);
```

transfer data the DTO to Entity
```java
userEntity = mapperObjectUserDTO.parse();
```
#### Collection to Collection data transfer
transfer data the Entity to DTO
```java
Mapper mapperObject = MapperObject.getInstance();
List<UserDTO> usersDTO = mapperObject.map(userEntities, UserDTO.class);
```
transfer data the DTO to Entity
```java
userEntities = new UserDTO().convertDomainList(usersDTO);
```

### License

Copyright 2016 Gabriel Perez.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[Apache License, Version 2.0](https://github.com/Gperez88/AndroidMapperObject/blob/master/LICENSE)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

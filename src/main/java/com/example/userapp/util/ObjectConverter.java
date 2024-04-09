package com.example.userapp.util;

import com.example.userapp.dto.User;
import com.example.userapp.model.UserEntity;

public class ObjectConverter {
    private ObjectConverter(){}
     public static UserEntity toUser(User userDto){
        UserEntity user=new UserEntity();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setEnabled(false); //while registration IsEnabled will be false and reset to true during login
         user.setEmail(userDto.getEmail());
         user.setRole(userDto.getRole());
        return user;
    }

    public static User toUserDTO(UserEntity userEntity){
        User user=new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setAddress(userEntity.getAddress());
        user.setEmail(userEntity.getEmail());
        user.setRole(userEntity.getRole());
        return user;
    }
}

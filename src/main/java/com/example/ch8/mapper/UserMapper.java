package com.example.ch8.mapper;


import com.example.ch8.to.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

   public abstract void insertUser(UserDto userDto)throws Exception;

   public abstract UserDto selectUser(Map map)throws Exception;

   public abstract UserDto selectUserEmail(String email);

   public abstract void updateUser(UserDto userDto)throws Exception;

   public abstract void deleteUser(String email)throws Exception;

}

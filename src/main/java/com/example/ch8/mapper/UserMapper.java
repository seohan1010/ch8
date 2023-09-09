package com.example.ch8.mapper;


import com.example.ch8.to.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

   public abstract void insertUser(UserDto userDto)throws Exception;

   public abstract UserDto selectUser(String name)throws Exception;

   public abstract void updateUser(UserDto userDto)throws Exception;

   public abstract void deleteUser(String name)throws Exception;

}

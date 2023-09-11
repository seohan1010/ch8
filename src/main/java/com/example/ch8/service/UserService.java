package com.example.ch8.service;


import com.example.ch8.to.UserDto;

import java.util.Optional;

public interface UserService {

public abstract void registerUser(UserDto userDto)throws Exception;
public abstract UserDto findUser(String name)throws Exception;
public abstract void modifyUser(UserDto userDto)throws Exception;
public abstract  void removeUser(String name)throws Exception;

}

package com.example.ch8.service;


import com.example.ch8.to.UserDto;

import java.util.Map;
import java.util.Optional;

public interface UserService {

public abstract void registerUser(UserDto userDto)throws Exception;
public abstract UserDto findUser(Map map)throws Exception;
public abstract UserDto findUserEmail(String email)throws Exception;
public abstract void modifyUser(UserDto userDto)throws Exception;
public abstract  void removeUser(Map map)throws Exception;

}

package com.example.ch8.service;

import com.example.ch8.mapper.UserMapper;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void registerUser(UserDto userDto) throws Exception {
                 userMapper.insertUser(userDto);
    }

    @Override
    public UserDto findUser(String name) throws Exception {
        return   userMapper.selectUser(name);
    }

    @Override
    public void modifyUser(UserDto userDto) throws Exception {
                userMapper.updateUser(userDto);
    }

    @Override
    public void removeUser(String name) throws Exception {
                userMapper.deleteUser(name);
    }
}

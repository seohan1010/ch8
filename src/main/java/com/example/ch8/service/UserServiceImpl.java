package com.example.ch8.service;

import com.example.ch8.mapper.UserMapper;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void registerUser(UserDto userDto) throws Exception {
                 userMapper.insertUser(userDto);
    }

    @Override
    public UserDto findUser(Map map) throws Exception {
        return   userMapper.selectUser(map);
    }

    @Override
    public UserDto findUserEmail(String email) throws Exception {
       return userMapper.selectUserEmail(email);
    }

    @Override
    public void modifyUser(UserDto userDto) throws Exception {
                userMapper.updateUser(userDto);

    }


    @Override
    public void removeUser(String email) throws Exception {
                userMapper.deleteUser(email);
    }
}

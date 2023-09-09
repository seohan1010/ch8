package com.example.ch8.controller;

import com.example.ch8.mapper.UserMapper;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
        @Autowired
        UserMapper userMapper;


        // 아이디를 받아와서 아이디가 존재하면은 비밀번호를 비교하고 비밀번호가 존재하면은 객체
        // 혹은 상태를 리턴하고 비밀번호가 존재하지 않으면은 예외를 던진다.

        @RequestMapping(value="/login",method = RequestMethod.POST)
        public UserDto loginCheck(UserDto userDto)throws Exception{

              UserDto userDto2 = userMapper.selectUser(userDto.getName());
              if(userDto != null &&userDto.getPassword().equals(userDto2.getPassword())){
                     return userDto2;
              }else{

                      throw new Exception();
              }

        }
}

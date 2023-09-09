package com.example.ch8.controller;

import com.example.ch8.service.UserService;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserService userService;


        @RequestMapping(value="/user", method= RequestMethod.POST)
        public void registerUser(UserDto userDto)throws Exception{
                userService.registerUser(userDto);
        }


        @RequestMapping(value="/user",method=RequestMethod.PUT)
        public void modifyUser(UserDto userDto)throws Exception{
                userService.modifyUser(userDto);
        }

        @RequestMapping(value="/user/{name}",method=RequestMethod.DELETE)
        public void deleteUser(@PathVariable("name") String name )throws Exception{
                 userService.removeUser(name);
        }


}

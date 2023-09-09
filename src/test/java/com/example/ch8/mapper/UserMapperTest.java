package com.example.ch8.mapper;

import com.example.ch8.to.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    //테스트 성공

    @Test
    @DisplayName("DI - Test")
    public void test(){

        System.out.println("userMapper = " + userMapper);

    }

    // 테스트 성공

    @Test
    @DisplayName("")
    public void insertTest()throws Exception{

        String name = "test name1";
        String password = "test pwd1";
        String email = "bbb@bbb.com";
        String sns ="";

        UserDto user = new UserDto();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
//      user.setSns();
        userMapper.insertUser(user);

    }

    //테스트 성공

    @Test
    @DisplayName("select - Test")
    public void selectTest()throws Exception{
        String name="test name1";
        UserDto user =  userMapper.selectUser(name);
        assertNotNull(user);
        System.out.println("user = " + user);

    }

    //테스트 성공

    @Test
    @DisplayName("update - Test")
    public void updateTest()throws Exception{

        String name = "test name1";
        String password = "modified test pwd";

        UserDto user = new UserDto();
        user.setName(name);
        user.setPassword(password);


        userMapper.updateUser(user);
        UserDto user2 = userMapper.selectUser(name);
        assertEquals(user2.getPassword(),password);


    }

    //테스트 성공

    @Test
    @DisplayName("delete - Test")
    public void deleteTest()throws Exception{

        String user = "test name1";
        userMapper.deleteUser(user);
        UserDto user2 = userMapper.selectUser(user);
        assertNull(user2);

    }






}
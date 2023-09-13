package com.example.ch8.mapper;

import com.example.ch8.to.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

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
    @DisplayName("insert - Test ")
    public void insertTest()throws Exception{

        String name="test";
        String email="aaa@aaa.com";
        String password = "11111111";
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
        String name="test";
        String email="aaa@aaa.com";

        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);

        UserDto user =  userMapper.selectUser(map);
        assertNotNull(user);
        System.out.println("user = " + user);

    }


    @Test
    @DisplayName("select email test")
    public void selectEmailTest(){

        String email = "aaa@aaa.com";
        UserDto user = userMapper.selectUserEmail(email);
        assertNotNull(user);
    }





    //테스트 성공

    //이메일은 업데이트를 할수가 없다.
    @Test
    @DisplayName("update - Test")
    public void updateTest()throws Exception{

        String name = "test";
        String email = "aaa@aaa.com";
        String password = "55555555";


        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("password",password);

        UserDto user = new UserDto();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);


        userMapper.updateUser(user);
        UserDto user2 = userMapper.selectUser(map);
        assertEquals(user2.getPassword(),password);
        System.out.println("<<<<<<<<<<<<< user2 = " + user2);


    }

    //테스트 성공

    @Test
    @DisplayName("delete - Test")
    public void deleteTest()throws Exception{

        String name="test";
        String email="aaa@aaa.com";
        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);


        userMapper.deleteUser(email);
        UserDto user2 = userMapper.selectUser(map);
        assertNull(user2);

    }






}
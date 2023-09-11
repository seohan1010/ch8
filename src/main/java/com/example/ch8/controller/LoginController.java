package com.example.ch8.controller;

import com.example.ch8.mapper.UserMapper;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


//이거는 다시 생각해서 작성해보자  로직이 좀 필요할거 같다.
// 동명이인인  user라면 입력된 비밀번호와 이메일로 비교하는 로직이 필요하다.
//@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {
        @Autowired
        UserMapper userMapper;

        // 왜 GET으로 가져오는지는 모르겠다.
        // ---> session에 저장된 정보만 가져오기 때문에 그런 걸지도 모르겠다.
        @RequestMapping(value="/logout", method=RequestMethod.GET)
        public ResponseEntity<HttpStatus> logout(HttpSession session) {
                // 1. 세션을 종료
                session.invalidate();
                // 2. 세션이 종료되었으면, 200번 코드를 전송
                return new ResponseEntity<HttpStatus>(HttpStatus.OK); //200
        }



        // 아이디를 받아와서 아이디가 존재하면은 비밀번호를 비교하고 비밀번호가 존재하면은 객체
        // 혹은 상태를 리턴하고 비밀번호가 존재하지 않으면은 에러 코드를 전송한다.

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public ResponseEntity<HttpStatus> login(@RequestBody UserDto userDto ,HttpServletRequest request ) throws Exception {

                String name = userDto.getName();
                String email = userDto.getEmail();
                String password = userDto.getPassword();
                System.out.println(userDto);
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("email", email);
               // map.put("password", password);
                UserDto userDto2 = userMapper.selectUser(map);
                System.out.println("userDto2 : "+userDto2);
                                // 객체의 주소가 아닌 객체의 필드의 값을 비교하는 로직이므로 equals를 이용해서 비교해야 한다.
                if ( userDto != null && userDto2.getPassword().equals(password)) {
                        // 아이디가 존재하고 비밀번호도 일치하면 request 객체로부터
                        // session 객체를 가지고 와서 user의 개인정보를 저장

                        HttpSession session = request.getSession();
                        session.setAttribute("name",name);
                        session.setAttribute("email",email);
                        session.setAttribute("password",password);

                        return new ResponseEntity<HttpStatus>(HttpStatus.OK); //200
                } else if (!userDto2.getPassword().equals(password)) {
                        //  비밀번호가 일치하지 않으면 에러코드를 보냄
                        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST); //400
                }
                        // 아이디가 일치하지 않아도 에러코드를 보냄
                        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE); //406


        }

}

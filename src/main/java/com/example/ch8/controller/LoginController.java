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
@RestController // @RestController를 사용하면은 데이터를 전송하기 위해 메서드마다 @ResponseBody를 작성해 줄지 않아도 된다.
@RequestMapping("/login")
public class LoginController {
        @Autowired
        UserMapper userMapper;

        // 왜 GET으로 가져오는지는 모르겠다.
        // ---> session에 저장된 정보만 가져오기 때문에 그런 걸지도 모르겠다.
        @RequestMapping(value="/logout", method=RequestMethod.GET)
        public ResponseEntity<HttpStatus> logout(HttpSession session) {
                System.out.println("session.getAttribute(\"email\") = " + session.getAttribute("email"));
                // 1. 세션을 종료
                session.invalidate();
                // 2. 세션이 종료되었으면, 200번 코드를 전송
                return new ResponseEntity<HttpStatus>(HttpStatus.OK); //200
        }



        // 아이디를 받아와서 아이디가 존재하면은 비밀번호를 비교하고 비밀번호가 존재하면은 객체
        // 혹은 상태를 리턴하고 비밀번호가 존재하지 않으면은 에러 코드를 전송한다.

        HttpServletRequest req;
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public ResponseEntity<HttpStatus> login(@RequestBody UserDto userDto ,HttpServletRequest request ) throws Exception {

                // isValid메서드에서 사용하기 위해서 필드에 선언된 메서드에 request 객체를 할당해준다.
                req=request;
                // isValid 메서드를 생성해서 조건에 따라 String을 반환하도록 해서
                // 반환받은 String값에 따라서 다른 코드를 리턴하도록 하는 코드를 작성하자.
                // 객체의 주소가 아닌 객체의 필드의 값을 비교하는 로직이므로 equals를 이용해서 비교해야 한다.

            try {
                if (isValid(userDto).equals("isValid")) {

                        return new ResponseEntity<HttpStatus>(HttpStatus.OK); //200
                } else if (isValid(userDto).equals("isNotValid")) {
                        //  비밀번호가 일치하지 않으면 에러코드를 보냄
                        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST); //400
                }

                // user가 null 일때 예외가 발생하지 않게 하기 위함
            } catch (Exception e) {

                return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE); //406
            }

            // 아이디가 일치하지 않아도 에러코드를 보냄
               return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);  //406


        }


        // login매핑된 메서드로 들어온 정보를 받아서 유효성검증을 한뒤에
        private String isValid(UserDto userDto)throws Exception{
                String name = userDto.getName();
                String email = userDto.getEmail();
                String password = userDto.getPassword();
                System.out.println(userDto);
                Map<String, String> map = new HashMap<>();
                map.put("email", email);
                // map.put("password", password);
                UserDto userDto2 = userMapper.selectUser(map);
                System.out.println("userDto2 : "+userDto2 == null?"user is null":userDto2);


                if(userDto != null && userDto2.getPassword().equals(password)){

                  // 아이디가 존재하고 비밀번호도 일치하면 request 객체로부터
                  // session 객체를 가지고 와서 user의 개인정보를 저장
                  // ---> request객체는 iv로 선언되어 있음
                  HttpSession session = req.getSession();
                  session.setAttribute("name",name);
                  session.setAttribute("email",email);
                  session.setAttribute("password",password);


                  System.out.println("session.getAttribute(\"email\") = " + session.getAttribute("email"));
                  System.out.println("session.getAttribute(\"password\") = " + session.getAttribute("password"));
                        return "isValid";
                }else {
                        return "isNotValid";
                }

        }



}

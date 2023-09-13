package com.example.ch8.controller;

import com.example.ch8.service.UserService;
import com.example.ch8.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

// user 컨트롤러에 RestController로

@RestController
@RequestMapping("/user")
public class UserController{

        @Autowired
        UserService userService;

        // @RequestBody를 사용하지 않으면은 http body의 내용을 받아올수 없는거 같다.
        // 다음 프로젝트에서는 유효성 검사를 하는 기능을 추가해야 겠다.
        @RequestMapping(value="/user", method= RequestMethod.POST)
        public ResponseEntity<HttpStatus> registerUser(@RequestBody UserDto userDto)throws Exception{
                System.out.println("request has been arrived at registerUser");
                System.out.println(userDto);
                try{
                    userService.registerUser(userDto);
                    return new ResponseEntity<HttpStatus>(HttpStatus.OK);
                }catch(Exception e){
                    e.printStackTrace();
                    //에러가 발생하면은 에러 코드를 반환
                    return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT); // 409

                }
        }


        // 회원가입을 하려고 submit을 할때, 해당 이메일이 존재하면은 사용자에게 알려준다.
        // 여기서 String으로 받아오면은 json객체그대로 받게되기 때문에
        // 이렇게 Map을 이용해서 "키" "값" 형태로 받아올수 있는거 같다.
        @RequestMapping(value="/email", method=RequestMethod.POST)
        public ResponseEntity<HttpStatus> emailCheck(@RequestBody HashMap<String, String> email )throws Exception{

                System.out.println("<<<<<<< email = " + email.get("email"));
                UserDto user = userService.findUserEmail(email.get("email"));
                System.out.println(">>>>>> user = " + user);
                if(user==null){
                    return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT); // 409번 코드
                    // else블럭에서만 return 하면은 오류가 나지 않는데,
                    // else if로 작성하면은 오류가 발생한다.
                }else{
                    return new ResponseEntity<HttpStatus>(HttpStatus.OK);       // 200번 코드
                }

        }



        // user 컨트롤러는 user의 정보를 url 혹은 uri에 노출할수 없기 때문에
        // restfull 하지는 못할거 같다.
        @RequestMapping(value="/modify",method=RequestMethod.POST)
        public ResponseEntity<HttpStatus> modifyUser(@RequestBody UserDto userDto)throws Exception{

                try {
                        userService.modifyUser(userDto);
                        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
                }catch(Exception e){
                        e.printStackTrace();
                        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
                }
        }


        // 아이디를 세션에 저장한 다음에 session에서 바로 가져오는지를 확인해 봐야겠다.
        // session에서 user의 정보를 가지고 와서 삭제하는 로직을 사용해야 겠다.\

        @RequestMapping(value="/delete",method=RequestMethod.POST)
        public ResponseEntity<HttpStatus> deleteUser(HttpSession session)throws Exception{

                String email = (String)session.getAttribute("email");
                System.out.println("<<<<<<<<<<< email = " + email);

                try {
                        userService.removeUser(email);
                        return new ResponseEntity<HttpStatus>(HttpStatus.OK);

                        // 예외가 발생했을때 에러코드를 보낸다
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
                }

        }


}

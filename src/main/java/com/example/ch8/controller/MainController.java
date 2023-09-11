package com.example.ch8.controller;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class MainController {

    // 메서드와 url을 매핑해주는 것을 엔드 포인트라고 한다.
@RequestMapping(value="/",method= RequestMethod.GET)
 public String main(HttpServletRequest request){

    System.out.println(request.getRequestURL());
    System.out.println("hello");

    return "Connection Successful";
}



}

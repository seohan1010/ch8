package com.example.ch8.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

@RequestMapping("/")
 public String main(HttpServletRequest request){

    System.out.println(request.getRequestURL());
    System.out.println("hello");

    return "hello";
}



}

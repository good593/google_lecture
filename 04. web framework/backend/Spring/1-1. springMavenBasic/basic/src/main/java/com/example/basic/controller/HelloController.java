package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //@RequestMapping >> GET, POST, PUT 등 모든 HTTP method 요청을 받음
public class HelloController {
  
  @GetMapping("/world") //@GetMapping >> GET 요청만 받을 수 있음 
  public String world(){
    return "Hello world";
  }
}

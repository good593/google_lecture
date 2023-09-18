package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
  
  // http://localhost:8080/hello
  @GetMapping("/hello")
  public @ResponseBody String hello() {
    log.info("index start!!");
    return "GetMapping >> Hello world";
  }

  // http://localhost:8080/hello
  @GetMapping("/message/hello")
  public @ResponseBody String messageHello() {
    log.info("index start!!");
    return "GetMapping >> message Filter >> Hello world";
  }

  // http://localhost:8080/variable/test
  @GetMapping(value = "/variable/{param1}")
  public @ResponseBody String getVariable(@PathVariable String param1) {
    return "GetMapping >> param1: "+param1;
  }

  // http://localhost:8080/variable/dto?name=name1&email=sample@gmail.com
  @GetMapping(value = "/variable/dto")
  public @ResponseBody String getVariableDto(@ModelAttribute UserDto dto) {
    
    return "GetMapping >> "+dto.toString();
  }

}

package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dto.BasicDto;

@RestController
@RequestMapping("/api/v1/post")
public class ControllerBasicPost {
  
  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public String postHello() {
    return "RequestMapping(POST) >> Hello world";
  }

  @PostMapping("/world")
  public String postWorld() {
    return "PostMapping >> Hello world";
  }

  @PostMapping("variable1/map")
  public String postVariable1(@RequestBody Map<String, String> params) {
    
    params.forEach((strKey, strValue)->{
      System.out.println( strKey +":"+ strValue );
    });

    return "PostMapping >> Map<String, String> params";
  }

  @PostMapping(value = "variable2/dto")
  public String getVariable2(@RequestBody BasicDto dto) {
    
    return "PostMapping >> "+dto.toString();
  }


  
}

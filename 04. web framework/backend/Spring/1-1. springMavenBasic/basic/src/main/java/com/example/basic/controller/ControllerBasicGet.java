package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.dto.BasicDto;
import com.example.basic.data.dto.BasicLombokDto;

@RestController
@RequestMapping("/api/v1/get") //@RequestMapping >> GET, POST, PUT 등 모든 HTTP method 요청을 받음
public class ControllerBasicGet {
  
  // http://localhost:8080/api/v1/hello/test
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String getHello() {
    return "RequestMapping(GET) >> Hello world";
  }

  // http://localhost:8080/api/v1/get/world
  @GetMapping("/world") //@GetMapping >> GET 요청만 받을 수 있음 
  public String getWorld() {
    return "GetMapping >> Hello world";
  }

  // http://localhost:8080/api/v1/get/variable1/test1
  @GetMapping(value = "variable1/{param1}")
  public String getVariable1(@PathVariable String param1) {
    return "GetMapping >> param1: "+param1;
  }

  // http://localhost:8080/api/v1/get/variable2/test1/test2
  @GetMapping(value = "variable2/{param1}/{param2}")
  public String getVariable2(@PathVariable String param1, @PathVariable String param2) {
    return "GetMapping >> params: "+param1 +" / "+param2;
  }

  // http://localhost:8080/api/v1/get/variable3/test1
  @GetMapping(value = "variable3/{param}")
  public String getVariable3(@PathVariable("param") String str1) {
    return "GetMapping >> str1: "+str1;
  }

  // http://localhost:8080/api/v1/get/variable4/query?name=name1&email=sample@gmail.com
  @GetMapping(value = "variable4/query")
  public String getVariable4(@RequestParam String name, @RequestParam String email) {
    return "GetMapping >> query: "+name + " / " + email;
  }

  // http://localhost:8080/api/v1/get/variable5/map?name=name1&email=sample@gmail.com
  @GetMapping(value = "variable5/map")
  public String getVariable5(@RequestParam Map<String, Object> params) {

    params.forEach((strKey, strValue)->{
      System.out.println( strKey +":"+ strValue );
    });

    return "GetMapping >> Map<String, Object> params";
  }

  // http://localhost:8080/api/v1/get/variable6/dto?name=name1&email=sample@gmail.com
  @GetMapping(value = "variable6/dto")
  public String getVariable6(BasicDto dto) {
    
    return "GetMapping >> "+dto.toString();
  }

  // http://localhost:8080/api/v1/get/variable7/dto?name=name1&email=sample@gmail.com
  @GetMapping(value = "variable7/dto")
  public String getVariable7(BasicLombokDto dto) {
    
    return "GetMapping >> "+dto.toString();
  }

}

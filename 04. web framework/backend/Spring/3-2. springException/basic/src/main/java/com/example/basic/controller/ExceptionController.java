package com.example.basic.controller;

import java.nio.file.FileSystemException;
import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exception")
public class ExceptionController {
  
  @GetMapping("/test")
  public String test() throws Exception {
    String message = "Hello World\n";

    try {
      message += "try start\n";
      throw new Exception("[ExceptionController][test] Exception 오류 발생!!");
    } catch (Exception e) {
      // TODO: handle exception
      message += e.getMessage();
    }

    return message;
  }

  @GetMapping("/exception")
  public void exceptionTest() throws Exception {
    throw new Exception("[ExceptionController][exceptionTest] Exception 오류 발생!!");
  }

  @GetMapping("/runtime-exception")
  public void runtimeExceptionTest() throws Exception {
    throw new RuntimeException("[ExceptionController][runtimeExceptionTest] RuntimeException 오류 발생!!");
  }

  @ExceptionHandler({FileSystemException.class, RuntimeException.class})
  public ResponseEntity<Map<String, String>> multiExceptionHandler(Exception e) {

    System.out.println("[ExceptionController][multiExceptionHandler] Start");
    System.out.println(e.getMessage());

    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    Map<String, String> map = new HashMap<>();
    map.put("error type", httpStatus.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "MultiExceptionHandler 입니다. ");

    return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Map<String, String>> defaultExceptionHandler(Exception e) {

    System.out.println("[ExceptionController][defaultExceptionHandler] Start");
    System.out.println(e.getMessage());

    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    Map<String, String> map = new HashMap<>();
    map.put("error type", httpStatus.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "DefaultExceptionHandler 입니다. ");

    return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }


}

package com.example.basic.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HubExceptionHandler {
  
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Map<String, String>> defaultExceptionHandler(Exception e) {

    System.out.println("[HubExceptionHandler][defaultExceptionHandler] Start");
    System.out.println(e.getMessage());

    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    Map<String, String> map = new HashMap<>();
    map.put("error type", httpStatus.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "RestControllerAdvice 입니다. ");

    return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }

}

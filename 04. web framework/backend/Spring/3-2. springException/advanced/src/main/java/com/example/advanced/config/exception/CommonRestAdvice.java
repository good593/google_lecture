package com.example.advanced.config.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommonRestAdvice {

    @ExceptionHandler(value = TodoException.class)
    public ResponseEntity<Map<String,Object>> todoExceptionHandler(TodoException e) {

        log.info("[CommonRestAdvice][todoExceptionHandler] Start");
        log.info("exception message: "+e.getMessage());

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = e.getHttpStatus();

        Map<String,Object> error_msg = new HashMap<>();
        error_msg.put("message", "잘못된 요청을 하셨습니다. 다시 확인해주세요.");
        error_msg.put("exception message", e.getMessage());

        return new ResponseEntity<>(error_msg, headers, status);
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,Object>> defaultExceptionHandler(Exception e) {
        
        log.info("[CommonRestAdvice][defaultExceptionHandler] Start");
        log.info("exception message: "+e.getMessage());

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String,Object> error_msg = new HashMap<>();
        error_msg.put("message", "죄송합니다. 다시 시도해주세요.");
        error_msg.put("exception message", e.getMessage());

        return new ResponseEntity<>(error_msg, headers, status);
    }
}

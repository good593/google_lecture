package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.LoginDto;
import com.example.basic.model.UserDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
    
    @GetMapping("/hello")
    public String hello() {

        log.info("[UserController][hello] Start");
        return "Hello World";
    }

    @PostMapping("/login/novalid")
    public String LoginNoValid(@RequestBody LoginDto dto) {

        log.info("[UserController][joinNoValid] Start");
        log.info("dto: "+dto.toString());
        return "로그인 완료 without Validation";
    }

    @PostMapping("/login/valid")
    public String LoginValid(@Valid @RequestBody LoginDto dto) {

        log.info("[UserController][joinValid] Start");
        log.info("dto: "+dto.toString());
        return "로그인 완료 with Validation";
    }

    @PostMapping("/join/novalid")
    public String joinNoValid(@RequestBody UserDto dto) {

        log.info("[UserController][joinNoValid] Start");
        log.info("dto: "+dto.toString());
        return "가입 완료 without Validation";
    }

    @PostMapping("/join/valid")
    public String joinValid(@Valid @RequestBody UserDto dto) {

        log.info("[UserController][joinValid] Start");
        log.info("dto: "+dto.toString());
        return "가입 완료 with Validation";
    }
}

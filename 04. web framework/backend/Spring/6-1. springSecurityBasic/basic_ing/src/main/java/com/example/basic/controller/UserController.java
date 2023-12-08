package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.basic.model.dto.UserDto;
import com.example.basic.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        log.info("[UserController][index] Start");
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        log.info("[UserController][logout] Start");
        return "redirect:/loginPage";
    }

    @GetMapping("/join")
    public String joinPage() {
        log.info("[UserController][joinPage] Start");
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto dto) {
        log.info("[UserController][join] Start");

        userService.joinUserDto(dto);
        return "redirect:/loginPage";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        log.info("[UserController][loginPage] Start");
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        log.info("[UserController][user] Start");
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        log.info("[UserController][admin] Start");
        return "admin";
    }
}

package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.User;
import com.example.basic.service.SecurityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {
  
  @Autowired
  private SecurityService service;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/user")
  public @ResponseBody String user() {
    return "user";
  }

  @GetMapping("/admin")
  public @ResponseBody String admin() {
    return "admin";
  }

  @GetMapping("/manager")
  public @ResponseBody String manager() {
    return "manager";
  }

  @GetMapping("/loginForm")
  public String loginForm() {
    return "loginForm";
  }

  @GetMapping("/joinForm")
  public String joinForm() {
    return "joinForm";
  }

  @PostMapping("/join")
  public String join(User user) {
    log.info("join start!!");
    log.info(user.toString());

    service.saveUser(user);

    return "redirect:/loginForm";
  }

}

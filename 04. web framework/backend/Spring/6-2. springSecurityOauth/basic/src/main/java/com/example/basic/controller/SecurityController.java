package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.config.auth.PrincipalDetails;
import com.example.basic.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {

  @GetMapping("/")
  public String index() {
    log.info("[SecurityController] index start!!");
    return "index";
  }

  @GetMapping("/user")
  public @ResponseBody String user() {
    log.info("[SecurityController] user start!!");
    return "user";
  }

  @GetMapping("/admin")
  public @ResponseBody String admin() {
    log.info("[SecurityController] admin start!!");
    return "admin";
  }

  @GetMapping("/manager")
  public @ResponseBody String manager() {
    log.info("[SecurityController] manager start!!");
    return "manager";
  }

  @GetMapping("/loginForm")
  public String loginForm() {
    log.info("[SecurityController] loginForm start!!");
    return "loginForm";
  }

  @GetMapping("/test/login")
  public @ResponseBody String testLogin(
    Authentication authentication, @AuthenticationPrincipal UserDetails userDetailsObj
  ) {
    log.info("[testLogin] ========================");
    UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
    log.info(userDetails.toString());
    log.info(userDetailsObj.toString());
    return "세션 정보 확인";
  }

}

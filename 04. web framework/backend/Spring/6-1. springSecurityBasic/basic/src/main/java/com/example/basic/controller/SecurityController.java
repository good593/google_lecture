package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

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

  @GetMapping("/joinForm")
  public String joinForm() {
    log.info("[SecurityController] joinForm start!!");
    return "joinForm";
  }

  @PostMapping("/join")
  public String join(@ModelAttribute User user) {
    log.info("[SecurityController] join start!!");
    log.info(user.toString());

    user.setRole("USER");
    // 스프링 시큐리티는 암호화되지 않은 비밀번호로 로그인을 할 수 없음 
    // 따라서 입력받은 비밀번호를 암호화 해야 함 
    String rawPassword = user.getPassword();
    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
    user.setPassword(encPassword);

    log.info(user.toString());

    userRepository.save(user);

    return "redirect:/loginForm";
  }

  @GetMapping("/no-secured")
  public @ResponseBody String noSecured() {
    return "no-secured";
  }

  @Secured("ADMIN")
  @GetMapping("/secured")
  public @ResponseBody String secured() {
    return "secured";
  }

  @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
  @GetMapping("/secured-roles")
  public @ResponseBody String securedRoles() {
    return "securedRoles";
  }
}

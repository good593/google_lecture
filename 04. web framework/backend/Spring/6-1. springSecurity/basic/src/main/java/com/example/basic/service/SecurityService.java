package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public void saveUser(User user) {
    log.info("join start!!");
    log.info(user.toString());

    user.setRole("MANAGER");

    // 스프링 시큐리티는 암호화되지 않은 비밀번호로 로그인을 할 수 없음 
    // 따라서 입력받은 비밀번호를 암호화 해야 함 
    String rawPassword = user.getPassword();
    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
    user.setPassword(encPassword);

    userRepository.save(user);
  }
}

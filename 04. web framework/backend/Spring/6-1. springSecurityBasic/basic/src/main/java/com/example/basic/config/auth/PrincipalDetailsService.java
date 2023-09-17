package com.example.basic.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

// 시큐리티 설정에서 loginProcessingUrl("/login") 요청이 오면,
// UserDetailsService의 loadUserByUsername 함수 실행!!
@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  // 시큐리티 session -> Authentication -> UserDetails 
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    User userEntity = userRepository.findByUsername(username);
    log.info("[PrincipalDetailsService][loadUserByUsername] start");
    if (userEntity != null) {
      log.info(userEntity.toString());
      return new PrincipalDetails(userEntity);
    }

    return null;
  }
  
}

package com.example.basic.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.basic.model.User;

import lombok.Data;

// Security Sessio -> Authentication -> (UserDetails, OAuth2User) 
// 일반적인 로그인인 경우 : UserDetails 
// OAuth 로그인인 경우: OAuth2User 
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

  private User user;
  private Map<String, Object> attributes;

  // 일반로그인용 생성자
  public PrincipalDetails(User user) {
    this.user = user;
  }

  // OAuth 로그인용 생성자 
  public PrincipalDetails(User user, Map<String, Object> attributes) {
    this.user = user;
    this.attributes = attributes;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    Collection<GrantedAuthority> collect = new ArrayList<>();
    // collect.add(new SimpleGrantedAuthority(user.getRole()));
    collect.add(new GrantedAuthority() {

      @Override
      public String getAuthority() {
        // TODO Auto-generated method stub
        return user.getRole();
      }
      
    });

    return collect;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    // 계정 만료 유무 확인
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // 계정 잠긴 유무 확인 
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // 계정 비번 오래 사용했는지 유무 확인 
    return true;
  }

  @Override
  public boolean isEnabled() {
    // 활성화된 계정인지 유무 확인
    return true;
  }

  @Override
  public Map<String, Object> getAttributes() {
    // TODO Auto-generated method stub
    return attributes;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }
  
}

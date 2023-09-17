package com.example.basic.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.basic.model.User;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인 진행 
// 로그인을 진행이 완료가 되면 시큐리티 session을 만들어줍니다. (Security ContextHolder)
// 오브젝트 -> Authentication 타입 객체 
// Authentication 안에 User 정보가 있어야 함 
// User 정보 -> UserDetails 타입 객체 

// Security Sessio -> Authentication -> UserDetails 
public class PrincipalDetails implements UserDetails {

  private User user;

  public PrincipalDetails(User user) {
    this.user = user;
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
  
}

package com.example.basic.config.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthenticationTypes {
  
  BadCredentialsException(401, "비밀번호불일치"),
  UsernameNotFoundException(402, "계정없음"),
  AccountExpiredException(403, "계정만료"),
  CredentialsExpiredException(404, "비밀번호만료"),
  DisabledException(405, "계정비활성화"),
  LockedException(406, "계정잠김"),
  NoneException(407, "알 수 없는 에러 입니다.");

  private int code;
  private String msg;
}

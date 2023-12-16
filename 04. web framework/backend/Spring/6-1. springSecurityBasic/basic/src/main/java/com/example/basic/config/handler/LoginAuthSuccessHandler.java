package com.example.basic.config.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.basic.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  @Lazy
  private UserService userService;

  /*
   * 성공적인 사용자 인증을 처리하는 데 사용되는 전략입니다.
   * 구현은 원하는 대로 할 수 있지만 일반적인 동작은 제어하는 것입니다.
   * 후속 목적지로의 탐색(리디렉션 또는 포워드 사용)
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // TODO Auto-generated method stub
      log.info("[LoginAuthSuccessHandler][onAuthenticationSuccess] Start");
    // 로그인 성공시, 로그인 유무 저장 
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    userService.updateIsLoginByName(userDetails.getUsername(), true);
    response.sendRedirect("/user/index");
    super.onAuthenticationSuccess(request, response, authentication);
  }


}

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

  @GetMapping("/loginForm")
  public String loginForm() {
    log.info("[SecurityController] loginForm start!!");
    return "loginForm";
  }


  @GetMapping("/test/no-oauth/login")
  public @ResponseBody String testNoOauthLogin(
    Authentication authentication, @AuthenticationPrincipal UserDetails userDetailsObj
  ) {
    log.info("[testNoOauthLogin] ========================");
    UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
    log.info(userDetails.toString());
    log.info(userDetailsObj.toString());
    return "일반적인 로그인 (OAuth 로그인 접근시 오류 발생)\n testNoOauthLogin를 이용해서 세션 정보 확인";
  }

  @GetMapping("/test/oauth/login")
  public @ResponseBody String testOAuthLogin(
    Authentication authentication,
    @AuthenticationPrincipal OAuth2User oauth2UserObj
  ) {
    log.info("[testOAuthLogin] ========================");
    OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
    log.info("oauth2User: ", oauth2User.getAttributes().toString());
    log.info("oauth2UserObj: ", oauth2UserObj.getAttributes().toString());
    
    return "OAuth 로그인 (일반적인 로그인 접근시 오류 발생)\n testOAuthLogin를 이용해서 세션 정보 확인";
  }

  @GetMapping("/test/mutil/login")
  public @ResponseBody String testMutilLogin(
    @AuthenticationPrincipal PrincipalDetails principalDetails
  ) {
    log.info("[testMutilLogin] ========================");
    log.info("principalDetails: ", principalDetails.getUser().toString());
    
    return "OAuth 로그인 or 일반적인 로그인\n testMutilLogin를 이용해서 세션 정보 확인";
  }

}

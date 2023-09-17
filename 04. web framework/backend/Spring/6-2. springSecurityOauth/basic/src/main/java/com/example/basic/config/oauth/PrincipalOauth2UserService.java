package com.example.basic.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.basic.config.auth.PrincipalDetails;
import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

  @Autowired
  private @Lazy BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    System.out.println("loadUser ======================================");
    // 구글로그인 완료 -> code를 리턴(OAuth-Client 라이브러리) -> AccessToken 요청 
    // -> userRequest -> loadUser 함수 -> 구글로부터 회원정보 받음 
    OAuth2User oAuth2User = super.loadUser(userRequest);

    String provider = userRequest.getClientRegistration().getClientId(); // google 
    String providerId = oAuth2User.getAttribute("sub");
    String username = provider + "_" + providerId;
    String email = oAuth2User.getAttribute("email");
    String password = bCryptPasswordEncoder.encode(username);
    String role = "USER";

    User userEntity = userRepository.findByUsername(username);

    // 신규 유저인 경우
    if (userEntity == null) {
      userEntity = new User();
      userEntity.setUsername(username);
      userEntity.setPassword(password);
      userEntity.setEmail(email);
      userEntity.setRole(role);
      userEntity.setProvider(providerId);
      userEntity.setProviderId(providerId);

      userRepository.save(userEntity);
    } 

    return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
  }
  
}

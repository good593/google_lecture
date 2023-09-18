package com.example.basic.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.basic.config.auth.PrincipalDetails;
import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;

// https://velog.io/@soojxng/05-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0%EC%99%80-OAuth-2.0%EC%9C%BC%EB%A1%9C-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-13-google-login
@Service
public class PrincipalOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>  {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  public @Lazy BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    // TODO Auto-generated method stub
    OAuth2UserService delegate = new DefaultOAuth2UserService();
    OAuth2User oAuth2User = delegate.loadUser(userRequest);

    String provider = userRequest.getClientRegistration().getClientId(); // google 
    String providerId = oAuth2User.getAttribute("sub");
    String username = provider + "_" + providerId;
    
    User userEntity = userRepository.findByUsername(username);
    // 기존 사용자 
    if (userEntity != null) {
      return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }

    // 신규 가입 
    String password = bCryptPasswordEncoder.encode(username);
    String email = oAuth2User.getAttribute("email");
    String role = "USER";

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setProvider(provider);
    user.setProviderId(providerId);
    user.setRole(role);

    userRepository.save(user);

    return new PrincipalDetails(user, oAuth2User.getAttributes());
  }


}

package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import com.example.basic.config.oauth.PrincipalOauth2UserService;
import com.example.basic.repository.UserRepository;

@Configuration
@EnableWebSecurity  // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됩니다.
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true) // @Secured 어노테이션 활성화, @PreAuthorize 어노테이션 활성화  
public class SecurityConfig {

  @Autowired
  private PrincipalOauth2UserService principalOauth2UserService;
  
  @Bean // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
  public BCryptPasswordEncoder encodePwd() {
    return new BCryptPasswordEncoder();
  }

  // Configuring HttpSecurity
  /**
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf(AbstractHttpConfigurer::disable);
    http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/user/**").authenticated() // 인증이되면 접근 가능 
        .requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER") // 인증&인가가 되면 접근 가능 
        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // 인증&인가가 되면 접근 가능
        .anyRequest().permitAll() // 누구나 접근 가능 
      )
      .oauth2Login(oauth2 -> oauth2 
          // 1. 코드받기(인증) 성공시, 2. 엑세스토큰(권한) + 사용자프로필정보
          // 3. 사용자프로필 정보를 가져옴 4. 그 정보를 토대로 회원가입 진행  
          .loginPage("/loginForm")
          .userInfoEndpoint(userInfo -> userInfo
            .userService(this.principalOauth2UserService)
          )
      )
      .formLogin(formLogin -> formLogin
        .loginPage("/loginForm")
        .loginProcessingUrl("/login") // login 주소가 호출이 되면, PrincipalDetailsService.loadUserByUsername() 실행 
        .defaultSuccessUrl("/") // 시큐리티 로그인 성공시 해당 url 주소로 이동 
        .permitAll()
      );

    return http.build();
  }
  
}



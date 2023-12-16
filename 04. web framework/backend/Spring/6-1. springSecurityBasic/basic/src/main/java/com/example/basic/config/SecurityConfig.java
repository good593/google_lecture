package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.basic.config.handler.LoginAuthFailureHandler;
import com.example.basic.config.handler.LoginAuthSuccessHandler;
import com.example.basic.config.handler.LogoutAuthSuccesshandler;

@Configuration // 스프링 설정 파일!!
@EnableWebSecurity // 여러가지 설정 중에서 시큐리티 설정!!
// @Secured 어노테이션 활성화, @PreAuthorize 어노테이션 활성화  
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true) 
public class SecurityConfig {
    
    // 비밀번호 암호화에서 사용할 객체
    @Bean
    public BCryptPasswordEncoder eCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private LoginAuthSuccessHandler loginAuthSuccessHandler;
    @Autowired
    private LoginAuthFailureHandler loginAuthFailureHandler;
    @Autowired
    private LogoutAuthSuccesshandler logoutAuthSuccesshandler;

    // @Bean
    // public AuthenticationSuccessHandler loginAuthSuccessHandler() {
    //     return new LoginAuthSuccessHandler();
    // }

    // @Bean
    // public AuthenticationFailureHandler loginAuthFailureHandler() {
    //     return new LoginAuthFailureHandler();
    // }

    // @Bean
    // public LogoutSuccessHandler logoutAuthSuccesshandler() {
    //     return new LogoutAuthSuccesshandler();
    // }


    @Bean
    // 인증(로그인) & 인가(권한)에 대한 시큐리티 설정!!
    public SecurityFilterChain finteFilterChain(HttpSecurity http) throws Exception {

        // CSRF란, Cross Site Request Forgery의 약자로, 
        // 한글 뜻으로는 사이트간 요청 위조를 뜻합니다.
        // https://devscb.tistory.com/123
        http.csrf(AbstractHttpConfigurer::disable);

        //인증 & 인가 설정!!
        http
            // http request 요청에 대한 화면 접근(url path) 권한 설정 
            .authorizeHttpRequests(authorize -> authorize
                // "/user" 와 같은 url path로 접근할 경우... 
                .requestMatchers("/user/**")
                    // 인증(로그인)만 접근 가능
                    .authenticated()
                // "/manager" 와 같은 url path로 접근할 경우...
                .requestMatchers("/manager/**")
                    // ADMIN, MANAGER이라는 권한을 갖은 사용자만 접근 가능 
                    .hasAnyAuthority("MANAGER", "ADMIN")
                // "/admin" 와 같은 url path로 접근할 경우...
                .requestMatchers("/admin/**")
                    // ADMIN이라는 권한을 갖은 사용자만 접근 가능 
                    .hasAnyAuthority("ADMIN")
                // 그외의 모든 url path는 누구나 접근 가능 
                .anyRequest().permitAll()
            )
            // 인증(로그인)에 대한 설정 
            .formLogin(formLogin -> formLogin
                // Controller에서 로그인 페이지 url path
                .loginPage("/loginPage")
                // 로그인 화면에서 form 테그의 action 주소(url path)
                // 그러면, Spring Security가 로그인 검증을 진행함!!!
                // Controller에서는 해당 "/login"을 만들 필요가 없음!! 
                .loginProcessingUrl("/login")
                // 로그인 성공시 
                .successHandler(loginAuthSuccessHandler)
                // .defaultSuccessUrl("/user/index")
                // 로그인 실패시 
                .failureHandler(loginAuthFailureHandler)
                // 그외의 모든 url path는 누구나 접근 가능 
                .permitAll()
            )
            // 로그아웃에 대한 설정 
            .logout(logout -> logout
                // 로그아웃 요청 url path 
                .logoutUrl("/logout")
                // 로그아웃 성공시
                .logoutSuccessHandler(logoutAuthSuccesshandler)
                .permitAll()
            );

        // 위에서 설정한 인증 & 인가를 Spring Boot Configuration에 적용!!
        return http.build();
    }

}

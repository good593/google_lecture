package com.example.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링 설정 객체야!!!
@EnableWebSecurity // 스피링 시큐리티 설정 객체야!!
// @Controller의 Method(Servlet)에서 
// 해당 어노테이션 활성화 -> @Secured, @PreAuthorize
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
    
    @Bean // 해당 메서드의 리턴되는 오브젝트(암호화 객체)를 IoC로 등록.
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    // 인증 & 인가 
    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // CSRF란, Cross Site Request Forgery의 약자로, 
        // 한글 뜻으로는 사이트간 요청 위조를 뜻합니다.
        // https://devscb.tistory.com/123
        http.csrf(AbstractHttpConfigurer::disable); // 개발용 
        http
            // url path에 대한 접근 권한 설정 
            .authorizeHttpRequests(authorize -> authorize
                // 인증(로그인)이 성공했을 때, (인가(권한)는 확인하지 않음)
                .requestMatchers("/user/**").authenticated() 
                // 인증(로그인) & 인가(권한) 모두 확인!!
                .requestMatchers("/admin/**")
                    .hasAnyAuthority("ADMIN")
                // 그 외의 모든 url은 다 허락함!! 
                // 인증 & 인가를 확인하지 않음..
                .anyRequest().permitAll()
            )
            // 인증(로그인)에 대한 세부 설정
            .formLogin(formLogin -> formLogin
                // 로그인 접속 url path 
                .loginPage("/loginPage")
                // 로그인 요청을 했을 때, 
                // SecurityConfig 실행!! -> 아이디/비번 확인!!!!
                .loginProcessingUrl("/login")
                // 최종 로그인(인증) 성공시 접속할 url path
                .defaultSuccessUrl("/user")
                .permitAll()
            );

        return http.build();
    }





}

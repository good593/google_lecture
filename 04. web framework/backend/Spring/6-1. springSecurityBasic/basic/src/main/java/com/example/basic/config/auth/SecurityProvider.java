package com.example.basic.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// https://velog.io/@dailylifecoding/spring-security-study-authenticationprovider
// https://gregor77.github.io/2021/05/18/spring-security-03/
// https://velog.io/@ewan/Spring-Security-Custom-Authentication-Provider
// https://soojae.tistory.com/55
@Configuration
public class SecurityProvider implements AuthenticationProvider {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SecurityUserService securityUserService;

    // ID, PW 검증 확인!!
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String username=(String) authentication.getName();
		String password=(String) authentication.getCredentials();

        // ID 검증 
        UserDetails userDetails = (SecurityUserDto)securityUserService.loadUserByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("There is no username >> "+username);
        }
        // PW 검증 
        else if (isNotMatches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Your password is incorrect.");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    // AuthenticationProvider는 요청이 오면 먼저 supports()를 통해서 인증(검증) 진행 유무 판단
    // supports()의 값이 true이면, authenticate()를 실행하여 인증(검증) 진행
    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean isNotMatches(String password, String encodePassword) {
        return !bCryptPasswordEncoder.matches(password, encodePassword);
    }
    
}

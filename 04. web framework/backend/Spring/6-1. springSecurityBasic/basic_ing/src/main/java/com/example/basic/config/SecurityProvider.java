package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.basic.config.auth.PrincipalDetailsService;

// https://cbn1218.tistory.com/11
// https://velog.io/@dailylifecoding/spring-security-study-authenticationprovider
@Configuration
public class SecurityProvider implements AuthenticationProvider {

    @Autowired
    private PrincipalDetailsService principalDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return false;
    }


    
}

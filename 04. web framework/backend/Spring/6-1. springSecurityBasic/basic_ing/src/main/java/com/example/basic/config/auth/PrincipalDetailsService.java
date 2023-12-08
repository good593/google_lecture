package com.example.basic.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.basic.model.dto.UserDto;
import com.example.basic.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        log.info("[PrincipalDetailsService][loadUserByUsername] Start");
        log.info("userId: "+userId);

        UserDto user = userRepository.getUserDtoByUserId(userId);
        if(user != null) {
            // 이미 가입이 된 사용자!!!
            log.info(user.toString());
            return new PrincipalDetails(user);
        }

        // 가입이 되지 않은 사용자!!
        return null;
    }
    
}

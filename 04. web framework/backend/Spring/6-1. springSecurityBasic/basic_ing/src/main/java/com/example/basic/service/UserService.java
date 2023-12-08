package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.basic.model.dto.UserDto;
import com.example.basic.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void joinUserDto(UserDto dto) {
        log.info("[UserService][joinUserDto] Start");

        // 권한 적용 
        dto.setRole("USER");
        if(dto.getUsername().equals("root")) {
            dto.setRole("ADMIN");
        }

        // 비밀번호 암호화 적용 
        String rawPwd = dto.getPassword();
        String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
        dto.setPassword(encodedPwd);

        log.info("dto: "+dto.toString());
        userRepository.save(dto);
    }
}

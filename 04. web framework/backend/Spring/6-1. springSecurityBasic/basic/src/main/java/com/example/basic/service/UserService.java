package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.basic.model.dto.UserDto;
import com.example.basic.model.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    public void joinUserDto(UserDto dto) {
        
        // 권한 적용 
        dto.setRole("USER");
        if(dto.getUsername().equals("admin")) {
            dto.setRole("ADMIN");
        } else if(dto.getUsername().equals("manager")) {
            dto.setRole("MANAGER");
        }

        // 비밀번호 암호화 적용
        String rawPwd = dto.getPassword();
        String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
        dto.setPassword(encodedPwd);

        // 신규 유저 database에 저장!!
        userRepository.save(dto);

    }

}

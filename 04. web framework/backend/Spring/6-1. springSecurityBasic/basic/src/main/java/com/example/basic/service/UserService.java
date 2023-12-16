package com.example.basic.service;

import javax.swing.text.StyledEditorKit.BoldAction;

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

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginByName(String name, Boolean isLogin) {
        UserDto dto = userRepository.getUserDtoByName(name);
        dto.setIsLogin(isLogin);
        userRepository.save(dto);
    }

    public void joinUserDto(UserDto dto) {
        
        // 권한 적용 
        dto.setRole("USER");
        if(dto.getName().equals("admin")) {
            dto.setRole("ADMIN");
        } else if(dto.getName().equals("manager")) {
            dto.setRole("MANAGER");
        }

        // 비밀번호 암호화 적용
        String rawPwd = dto.getPwd();
        String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
        dto.setPwd(encodedPwd);

        dto.setIsLogin(false);

        // 신규 유저 database에 저장!!
        userRepository.save(dto);
    }

}

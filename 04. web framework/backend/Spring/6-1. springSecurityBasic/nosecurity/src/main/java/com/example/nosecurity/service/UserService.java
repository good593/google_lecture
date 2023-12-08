package com.example.nosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nosecurity.model.dto.UserDto;
import com.example.nosecurity.model.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // 가입(insert)
    public void joinUser(UserDto dto) {

        // (Default)그렇지 않은 경우는 일반 유저 권한 부여
        dto.setUserRole("custom");

        // 만약 id가 root이면, admin 권한 부여 
        if(dto.getUserId().equals("root")) {
            dto.setUserRole("admin");
        }

        userRepository.save(dto);
    }
    // 로그인(select)
    public UserDto loginUser(UserDto dto) {
        // 1. userId에 해당하는 user가 있는지?
        // 1-1. 만약에 있다면, pw가 같은지 확인!!!
        // 다르면, 비밀번호 오류!!!
        // 1-2. 만약에 없다면, 신규가입 유도!!!

        UserDto savedUser = userRepository.getUserDtoByUserId(dto.getUserId());
        // 신규가입 유도!!
        if(savedUser == null) {
            return null;
        }
        // 비밀번호 다름!!!
        else if(!savedUser.getUserPassword().equals(dto.getUserPassword())) {
            return dto; // dto는 email & role 없어요. 이것을 통해 구분...
        }

        // 정상적인 로그인 성공!!
        return savedUser; // email & role이 있어요. 
    }

}

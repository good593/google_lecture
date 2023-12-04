package com.example.advanced.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.model.dto.UserDto;
import com.example.advanced.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    public UserDto getDtoById(long id) {
        log.info("[UserService][getDtoById] Start");

        // 검증 로직!!!
        if(id == 0) {
            log.error("[UserService][getDtoById] error");
            return new UserDto();
        } 

        // 검증 로직 통과한 경우 비지니스 로직 실행!!
        return userRepository.getReferenceById(id);
    }

    public void insertDto(UserDto dto) {

        log.info("[UserService][insertDto] Start");
        userRepository.save(dto);
    }

    public String getUserNameById(Long userId) {

        log.info("[UserService][getUserNameById] Start");
        return userRepository.getUserNameById(userId);
    }

    public List<UserDto> findByUserNameStartingWith(String firstName) {

        log.info("[UserService][findByUserNameStartingWith] Start");
        return userRepository.findByUserNameStartingWith(firstName);
    }

    public void updateDto(UserDto dto) {
        UserDto user = userRepository.findByUserName(dto.getUserName());

        if(dto.getUserAge() > 0) {
            user.setUserAge(dto.getUserAge());
        }

        userRepository.save(user);
    }

    public void deleteDto(UserDto dto) {
        UserDto user = userRepository.findByUserName(dto.getUserName());
        
        userRepository.delete(user);
    }
}

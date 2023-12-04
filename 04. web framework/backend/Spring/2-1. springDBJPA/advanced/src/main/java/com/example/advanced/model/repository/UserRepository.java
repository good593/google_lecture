package com.example.advanced.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.advanced.model.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    
    // 사용자 쿼리문 이용!!!
    @Query(value="select user_name from customer where id= :userId", nativeQuery= true)
    public String getUserNameById(@Param("userId") Long userId);

    // JPA Query Method!!
    // userName으로 시작하는 모든 이름들을 조회!!!
    public List<UserDto> findByUserNameStartingWith(String firstName);

}
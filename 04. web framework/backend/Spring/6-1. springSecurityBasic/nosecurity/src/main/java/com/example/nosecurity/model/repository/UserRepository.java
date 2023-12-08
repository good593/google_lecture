package com.example.nosecurity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.nosecurity.model.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, String> {
    
    @Query(value ="SELECT u.* FROM custom u WHERE u.user_id = :userId", nativeQuery= true)
    UserDto getUserDtoByUserId(@Param(value = "userId") String userId);
}

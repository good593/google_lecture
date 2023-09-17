package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
  // findBy 규칙 
  // findByUsername() -> select * from user where username = 1?
  public User findByUsername(String username);

}

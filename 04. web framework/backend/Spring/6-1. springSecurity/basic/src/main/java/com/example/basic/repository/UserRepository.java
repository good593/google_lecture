package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
}

package com.example.advanced.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.advanced.model.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    
}

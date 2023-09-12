package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository< ToDo, Long> {
}

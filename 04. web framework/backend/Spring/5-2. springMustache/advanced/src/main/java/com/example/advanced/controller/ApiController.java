package com.example.advanced.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.service.TodoService;

@RestController
@RequestMapping("/api/ver1")
public class ApiController {
    
    @Autowired
    private TodoService todoService;

    // 전체 데이터 조회 
    @GetMapping("/all")
    public List<TodoDto> selectAll() {

        return todoService.selectAll();
    }

    // 데이터 저장 
    // localhost:8080/api/ver1/insert
    @PostMapping("/insert")
    public String insertTodo(@RequestBody TodoDto dto) {

        todoService.insertTodo(dto.getTodoName());
        return "저장 성공";
    }

    // 데이터 수정 
    @PostMapping("/update")
    public String updateTodo(@RequestBody TodoDto dto) {

        todoService.updateTodo(dto.getId());
        return "수정 성공";
    }

    // 데이터 삭제 
    @PostMapping("/delete")
    public String deleteTodo(@RequestBody TodoDto dto) {

        todoService.deleteTodo(dto.getId());
        return "삭제 성공";
    }

}

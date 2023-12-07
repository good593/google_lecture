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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ver1")
public class ApiController {
    
    @Autowired
    private TodoService todoService;

    //조회 
    @GetMapping("/all")
    public List<TodoDto> selectAll() throws Exception {
        return todoService.selectAll();
    }

    /*
    예제: {
        "name":"Spring",
        "progressPercentage":0,
        "duDate":"2023-12-08"
    }
     */
    @PostMapping("/insert")
    public String insertTodo(@Valid @RequestBody TodoDto dto) throws Exception {

        todoService.insertTodo(dto);
        return "추가 성공";
    }

    // 수정 
    @PostMapping("/update")
    public String updateTodo(@RequestBody TodoDto dto) throws Exception {

        todoService.updateTodo(dto);
        return "수정 성공";
    }

    // 삭제
    @PostMapping("/delete")
    public String deleteTodo(@RequestBody TodoDto dto) throws Exception {

        todoService.deleteTodo(dto.getId());
        return "삭제 성공";
    } 

}

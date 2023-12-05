package com.example.advanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/todo")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    // localhost:8080/todo/
    @GetMapping("/")
    public String selectTodoAll(Model model) {
        log.info("[TodoController][selectTodoAll] Start");

        model.addAttribute("todoList", todoService.selectTodoAll());
        return "todo"; // 화면 파일 이름!!!
    }

    // localhost:8080/todo/save
    @PostMapping("/save")
    public String insertTodo(@ModelAttribute TodoDto todo) {
        log.info("[TodoController][insertTodo] Start");
        log.info("todo: "+todo.toString());

        todoService.insertTodo(todo);
        return "redirect:/todo/";
    }

    @GetMapping("/finished/{id}")
    public String updateTodo(@PathVariable Long id) {
        log.info("[TodoController][updateTodo] Start");
        log.info("id: "+id);

        todoService.updateTodo(id);
        return "redirect:/todo/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        log.info("[TodoController][deleteTodo] Start");
        log.info("id: "+id);
        
        todoService.deleteTodo(id);
        return "redirect:/todo/";
    }
}

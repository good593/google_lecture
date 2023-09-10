package com.example.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.domain.ToDo;
import com.example.todoapp.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);

        // model.addAttribute(attributeName:"todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo) {
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);

        return "redirect:/";
    }
}

package com.example.advanced.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    public List<TodoDto> selectTodoAll() {
        log.info("[TodoService][selectTodoAll] Start");

        List<TodoEntity> entityList = todoDao.selectTodoAll();

        List<TodoDto> todoList = new ArrayList<>();
        for(TodoEntity entity:entityList) {
            TodoDto dto = new TodoDto(entity.getId(), entity.getTitle(), entity.getStatus());
            todoList.add(dto);
        }

        return todoList;
    }

    public void insertTodo(TodoDto todo) {
        log.info("[TodoService][insertTodo] Start");

        todo.setStatus("false");
        TodoEntity entity = new TodoEntity();
        entity.setTitle(todo.getTitle());
        entity.setStatus(todo.getStatus());
        todoDao.insertTodo(entity);
    }

    public void updateTodo(Long id) {
        log.info("[TodoService][updateTodo] Start");
        // 검증 로직 
        if(id <= 0) {
            log.info("[TodoService][updateTodo] error: no id");
            return;
        }

        TodoEntity entity = new TodoEntity();
        entity.setId(id);
        entity.setStatus("true");
        todoDao.updateTodo(entity);
    }

    public void deleteTodo(Long id) {
        log.info("[TodoService][deleteTodo] Start");
        // 검증 로직 
        if(id <= 0) {
            log.info("[TodoService][deleteTodo] error: no id");
            return;
        }

        todoDao.deleteTodo(id);
    }
}

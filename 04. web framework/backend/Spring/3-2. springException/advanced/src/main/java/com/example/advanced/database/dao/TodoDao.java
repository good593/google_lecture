package com.example.advanced.database.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.repository.TodoRepository;
import com.example.advanced.model.entity.TodoEntity;

@Service
public class TodoDao {
    
    @Autowired
    private TodoRepository todoRepository;

    // 조회
    public List<TodoEntity> selectAll() throws Exception {
        return todoRepository.findAll();
    }

    // 아이디를 이용하여 조회 
    public TodoEntity getTodoById(Long id) throws Exception {
        return todoRepository.getReferenceById(id);
    }
    
    // 추가 
    public void insertTodo(TodoEntity entity) throws Exception {
        todoRepository.save(entity);
    }

    // 수정 
    public void updateTodo(TodoEntity entity) throws Exception {
        TodoEntity saved = todoRepository.getReferenceById(entity.getId());
        if(entity.getStatus()) {
            saved.setStatus(entity.getStatus());
        }
        if(entity.getProgressPercentage() > 0) {
            saved.setProgressPercentage(entity.getProgressPercentage());
        }
        
        todoRepository.save(saved);
    }

    // 삭제 
    public void deleteTodo(Long id) throws Exception {
        todoRepository.deleteById(id);
    }

}

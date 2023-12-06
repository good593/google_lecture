package com.example.advanced.database.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.repository.TodoRepository;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoDao {
    
    @Autowired
    private TodoRepository todoRepositiry;

    // 전체 데이터 조회 
    public List<TodoEntity> selectAll() {

        log.info("[TodoDao][selectAll] Start");
        List<TodoEntity> entityList = todoRepositiry.findAll();

        log.info("entityList count: "+entityList.size());
        return entityList;
    }

    // 데이터 추가 
    public void insertTodo(TodoEntity entity) {

        log.info("[TodoDao][insertTodo] Start");
        log.info("entity: "+entity.toString());
        todoRepositiry.save(entity);
    }

    // 데이터 수정 
    // -> false(미완료) -> true(완료) 변경된 내용을 저장!!
    public void updateTodo(TodoEntity entity) {

        log.info("[TodoDao][updateTodo] Start");
        log.info("entity: "+entity.toString());
        // entity: 화면에서 넘어온 수정할 데이터!!!
        // 1. MySQL에 있는 저장된 savedEntity 조회한 후
        TodoEntity savedEntity = todoRepositiry.getReferenceById(entity.getId());
        if(entity.getStatus().equals(true)) {

            log.info("[TodoDao][updateTodo] saving Entity");
            // 2. 저장된 savedEntity에 수정할(status) 데이터(entity)를 update
            savedEntity.setStatus(entity.getStatus());
            // 3. savedEntity를 MySQL 저장!!!
            todoRepositiry.save(savedEntity);
        }
    }

    // 데이터 삭제 
    public void deleteTodo(Long id) {

        log.info("[TodoDao][deleteTodo] Start");
        log.info("id: "+id);
        todoRepositiry.deleteById(id);
    }
}

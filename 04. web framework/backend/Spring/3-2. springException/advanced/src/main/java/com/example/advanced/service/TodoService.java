package com.example.advanced.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.config.constant.ExceptionConstant;
import com.example.advanced.config.exception.TodoException;
import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    // 조회 
    public List<TodoDto> selectAll() throws Exception {
        List<TodoEntity> entities = todoDao.selectAll();

        List<TodoDto> todoDtos = new ArrayList<>();
        for(TodoEntity entity: entities) {
            TodoDto dto = new TodoDto(entity.getId(), entity.getName(), entity.getStatus()
            , entity.getProgressPercentage(), entity.getDuDate());

            todoDtos.add(dto);
        }

        return todoDtos;

    }
    // 추가 
    public void insertTodo(TodoDto dto) throws Exception {
        log.info("[TodoService][insertTodo] Start");
        log.info("dto: "+dto.toString());

        TodoEntity entity = new TodoEntity();
        entity.setName(dto.getName());
        entity.setStatus(false);
        entity.setProgressPercentage(0);
        entity.setDuDate(dto.getDuDate());

        todoDao.insertTodo(entity);
    }

    // 삭제
    public void deleteTodo(Long id) throws Exception {
        todoDao.deleteTodo(id);
    }

    // 수정 
    public void updateTodo(TodoDto dto) throws Exception {
        log.info("[TodoService][updateTodo] Start");
        log.info("dto: "+dto.toString());

        // 데이터 검증!!!
        this.updateValid(dto);

        TodoEntity entity = new TodoEntity();
        entity.setId(dto.getId());
        entity.setProgressPercentage(dto.getProgressPercentage());
        entity.setStatus(dto.getStatus());

        todoDao.updateTodo(entity);
    }

    private void updateValid(TodoDto dto) throws Exception {
        log.info("[TodoService][updateValid] Start");

        if(dto.getProgressPercentage() == 100 
            && dto.getStatus().equals(false) ) {
            throw new TodoException(ExceptionConstant.ProgressPercentage100);
            // throw new Exception("진행률 100%이지만, 상태값이 false(미완료)임.");
        }

        if(dto.getStatus().equals(true) 
            && dto.getProgressPercentage() != 100) {
            throw new TodoException(ExceptionConstant.StatusTrue);
            // throw new Exception("상태값이 true(완료)이지만, 진행률이 100%아님.");
        }

        TodoEntity saved = todoDao.getTodoById(dto.getId());
        Date now = new Date();

        if(now.after(saved.getDuDate())) {
            throw new TodoException(ExceptionConstant.ExpirationDate);
            // throw new Exception("마감일이 지났습니다. ㅠㅠ");
        }
        
        log.info("[TodoService][updateValid] End");
    }

}

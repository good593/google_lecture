package com.example.advanced.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    // 전체 데이터 조회
    public List<TodoDto> selectAll() {
        // dao로 부터 Entity리스트를 전달 받는다..
        List<TodoEntity> entityList = todoDao.selectAll();
        // dto리스트로 생성한다.
        List<TodoDto> dtoList = new ArrayList<>();
        
        for(TodoEntity entity: entityList) {
            // entity에 있는 데이터를 dto에 적용한다.
            TodoDto dto = new TodoDto(
                entity.getId(), entity.getTodo_name()
                , entity.getStatus());
            
            // dtoList에 생성된 dto 추가...
            dtoList.add(dto);
        }

        return dtoList;
    }

    // 데이터 추가 
    // controller는 dto만 사용!!
    // dao는 entity만 사용!!
    // 따라서 서비스는 dto를 entity로 변환해야함!!
    public void insertTodo(String todoName) {

        TodoEntity entity = new TodoEntity();
        entity.setTodo_name(todoName);
        // 처음 등록되는 todo는 상태값이 무조건 false!!
        entity.setStatus(false); 

        // dao를 통해 저장
        todoDao.insertTodo(entity);
    }

    // 데이터 수정
    public void updateTodo(Long id) {

        TodoEntity entity = new TodoEntity();
        entity.setId(id);
        // todo 완료 적용!!!
        entity.setStatus(true);

        todoDao.updateTodo(entity);
    }

    // 데이터 삭제 
    public void deleteTodo(Long id) {
        todoDao.deleteTodo(id);
    }

}

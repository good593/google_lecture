package com.example.advanced.model.dto;

import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    
    private Long id; // 아이디 
    @NotBlank
    @Size(min = 2, max = 10)
    private String name; // 할일 이름 
    // 할일에 대한 상태값: true(완료) / false(비완료)
    private Boolean status; 
    // 할일에 대한 진행률: 진행률이 100%면, status값이 true 
    @Min(value = 0)
    @Max(value = 100)
    private int progressPercentage; 
    // 할일의 마감일!! (마감일이 지나면, status & progressPercentage 수정 불가!!)
    @Future
    private Date duDate;
}

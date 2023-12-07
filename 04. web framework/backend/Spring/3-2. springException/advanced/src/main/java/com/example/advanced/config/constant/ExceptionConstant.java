package com.example.advanced.config.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionConstant {
    
    ProgressPercentage100("진행률 100%이지만, 상태값이 false(미완료)임."),
    StatusTrue("상태값이 true(완료)이지만, 진행률이 100%아님."),
    ExpirationDate("마감일이 지났습니다.");

    private final String errorMessage;

}

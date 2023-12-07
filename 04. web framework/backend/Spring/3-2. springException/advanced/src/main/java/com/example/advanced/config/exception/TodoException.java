package com.example.advanced.config.exception;

import org.springframework.http.HttpStatus;

import com.example.advanced.config.constant.ExceptionConstant;

import lombok.Getter;

@Getter
public class TodoException extends Exception {

    private HttpStatus httpStatus;

    public TodoException(ExceptionConstant exceptionConstant) {
        super(exceptionConstant.getErrorMessage());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}

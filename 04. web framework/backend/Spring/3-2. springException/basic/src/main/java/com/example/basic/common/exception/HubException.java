package com.example.basic.common.exception;

import org.springframework.http.HttpStatus;

import com.example.basic.common.constant.ExceptionConstant;

import lombok.Getter;

@Getter
public class HubException extends Exception {
  
  private ExceptionConstant exceptionConstant;
  private HttpStatus httpStatus;

  public HubException(ExceptionConstant exceptionConstant, HttpStatus httpStatus) {
    super(exceptionConstant.getExceptionType()+": "+ exceptionConstant.getDefaultMessage());

    this.exceptionConstant = exceptionConstant;
    this.httpStatus = httpStatus;
  }

  public HubException(ExceptionConstant exceptionConstant, HttpStatus httpStatus, String message) {
    super(exceptionConstant.getExceptionType()+": "+ message);

    this.exceptionConstant = exceptionConstant;
    this.httpStatus = httpStatus;
  }


}

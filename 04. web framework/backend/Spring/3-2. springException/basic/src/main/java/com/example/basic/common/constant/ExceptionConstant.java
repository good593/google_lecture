package com.example.basic.common.constant;

import lombok.Getter;

@Getter
public enum ExceptionConstant {
  
  PRODUCT("Product", "Product Error Message"), SIGN("Sign", "Sign Error Message");

  private final String exceptionType;
  private final String defaultMessage;

  ExceptionConstant(String exceptionType, String defaultMessage) {
    this.exceptionType = exceptionType;
    this.defaultMessage = defaultMessage;
  }

}


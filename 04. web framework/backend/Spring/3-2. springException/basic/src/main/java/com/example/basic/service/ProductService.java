package com.example.basic.service;

import org.springframework.stereotype.Service;

import com.example.basic.common.constant.ExceptionConstant;

@Service
public class ProductService {
  
public String exceptionTest(String exception_type) throws Exception  {
    
    ExceptionConstant constant = ExceptionConstant.valueOf(exception_type);
    return constant.getDefaultMessage();
  }

}

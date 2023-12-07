package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.common.constant.ExceptionConstant;
import com.example.basic.common.exception.HubException;
import com.example.basic.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/custom-exception")
    public void customExceptionTest() throws Exception {
        throw new HubException(ExceptionConstant.PRODUCT, HttpStatus.FORBIDDEN, "customException Test!!");
    }
    
    @GetMapping("/custom-exception-no-message")
    public void customExceptionWithoutMessageTest() throws Exception {
        throw new HubException(ExceptionConstant.PRODUCT, HttpStatus.FORBIDDEN);
    }
    
    @GetMapping("/exception-test/{exception-type}")
    public String exceptiontest(@PathVariable("exception-type") String exception_type) throws Exception  {

        return productService.exceptionTest(exception_type);
    }

    @GetMapping("/testOk")
    public String testOk() throws Exception {
        return productService.testOk();
    }

    @GetMapping("/daoException")
    public String daoException() throws Exception {
        return productService.daoException();
    }

        @GetMapping("/serviceException")
    public String serviceException() throws Exception {
        return productService.serviceException();
    }

}

package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.common.constant.ExceptionConstant;
import com.example.basic.dao.ProductDao;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public String exceptionTest(String exception_type) throws Exception  {
        
        ExceptionConstant constant = ExceptionConstant.valueOf(exception_type);
        return constant.getDefaultMessage();
    }

    public String testOk() throws Exception {
        return productDao.testOk();
    }

    public String daoException() throws Exception {
        return productDao.daoException();
    }

    public String serviceException() throws Exception {
        throw new Exception("[ProductService][serviceException] 오류입니다.");
    }

}

package com.example.basic.dao;

import org.springframework.stereotype.Service;

@Service
public class ProductDao {
    
    public String testOk() throws Exception {
        return "[BasicDao][testOk] 정상입니다.";
    }

    public String daoException() throws Exception {
        throw new Exception("[BasicDao][daoException] 오류입니다.");
    }
}

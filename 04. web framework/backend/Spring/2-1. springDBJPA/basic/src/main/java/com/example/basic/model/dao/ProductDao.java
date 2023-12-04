package com.example.basic.model.dao;

import com.example.basic.model.entity.ProductEntity;

public interface ProductDao {
    
    // select  
    public ProductEntity findByProductName(String productName);

    // jpa에서 제공하는 insert 기능함수
    // save + 테이블명: 함수명 
    public void saveProduct(ProductEntity productEntity);

    // jpa에서 제공하는 update
    // update + table name
    public void updateProduct(ProductEntity productEntity);

    public void deleteProduct(String productId);
}

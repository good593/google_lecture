package com.example.basic.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.dao.ProductDao;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.model.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity findByProductName(String productName) {
        // TODO Auto-generated method stub

        log.info("[ProductDaoImpl][findByProductName] Start");
        return productRepository.findByProductName(productName);
    }

    @Override
    public void deleteProduct(String productId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveProduct(ProductEntity productEntity) {
        // TODO Auto-generated method stub
        
        productRepository.save(productEntity);
    }

    @Override
    public void updateProduct(ProductEntity productEntity) {
        // TODO Auto-generated method stub
        
    }

    
}

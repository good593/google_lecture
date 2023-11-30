package com.example.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.entity.ProductEntity;
import com.example.basic.model.repository.ProductMapper;

@Service
public class ProductService {
    
    @Autowired
    private ProductMapper productMapper;

    public List<ProductEntity> selectProductAll() {

        List<ProductEntity> productList = productMapper.selectProductAll();
        return productList;
    }

        public List<ProductEntity> selectProductFilter(ProductEntity product) {

            List<ProductEntity> productList = productMapper.selectProductFilter(
                product.getProductPrice(), product.getProductName()
            );
        return productList;
    }
}

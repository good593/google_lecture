package com.example.basic.database.dao;

import com.example.basic.model.entity.ProductEntity;

public interface ProductDAO {
  
  ProductEntity saveProduct(ProductEntity productEntity);
  ProductEntity getProduct(String productId);
}

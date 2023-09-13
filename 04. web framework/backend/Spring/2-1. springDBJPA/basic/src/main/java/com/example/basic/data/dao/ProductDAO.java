package com.example.basic.data.dao;

import com.example.basic.data.entity.ProductEntity;

public interface ProductDAO {
  
  ProductEntity saveProduct(ProductEntity productEntity);
  ProductEntity getProduct(String productId);
}

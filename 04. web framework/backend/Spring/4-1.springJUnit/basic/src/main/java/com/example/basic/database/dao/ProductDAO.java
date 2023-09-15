package com.example.basic.database.dao;

import java.util.List;

import com.example.basic.model.entity.ProductEntity;



public interface ProductDAO {
  
  void saveProduct(ProductEntity productEntity);
  void updateProduct(ProductEntity productEntity);
  void deleteProduct(String productId);
  ProductEntity getProduct(String productId);
  List<ProductEntity> selectAllProducts();

}

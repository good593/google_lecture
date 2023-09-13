package com.example.basic.database.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.database.dao.ProductDAO;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.database.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ProductEntity getProduct(String productId) {
    // TODO Auto-generated method stub
    ProductEntity productEntity = productRepository.getReferenceById(productId);
    return productEntity;
  }

  @Override
  public ProductEntity saveProduct(ProductEntity productEntity) {
    // TODO Auto-generated method stub
    productRepository.save(productEntity);
    return productEntity;
  }
  
}

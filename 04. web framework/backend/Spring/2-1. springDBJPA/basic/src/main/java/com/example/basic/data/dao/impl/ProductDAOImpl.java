package com.example.basic.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.data.dao.ProductDAO;
import com.example.basic.data.entity.ProductEntity;
import com.example.basic.data.repository.ProductRepository;

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

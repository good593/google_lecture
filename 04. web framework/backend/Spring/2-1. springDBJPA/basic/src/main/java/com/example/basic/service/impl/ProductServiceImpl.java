package com.example.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.database.dao.ProductDAO;
import com.example.basic.model.dto.ProductDto;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDAO productDAO;

  @Override
  public ProductDto getProduct(String productId) {
    // TODO Auto-generated method stub
    ProductEntity productEntity = productDAO.getProduct(productId);

    ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName()
      , productEntity.getProductPrice(), productEntity.getProductStock());

    return productDto;
  }

  @Override
  public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
    // TODO Auto-generated method stub
    ProductEntity productEntity = new ProductEntity();
    productEntity.setProductId(productId);
    productEntity.setProductName(productName);
    productEntity.setProductPrice(productPrice);
    productEntity.setProductStock(productStock);

    ProductEntity savedProductEntity = productDAO.saveProduct(productEntity);

    ProductDto productDto = new ProductDto(savedProductEntity.getProductId(), savedProductEntity.getProductName()
      , savedProductEntity.getProductPrice(), savedProductEntity.getProductStock());

    return productDto;
  }
  
}

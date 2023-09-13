package com.example.basic.service;

import com.example.basic.model.dto.ProductDto;

public interface ProductService {
  
  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
  ProductDto getProduct(String productId);
}

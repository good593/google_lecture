package com.example.basic.service;

import com.example.basic.data.dto.ProductDto;

public interface ProductService {
  
  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
  ProductDto getProduct(String productId);
}

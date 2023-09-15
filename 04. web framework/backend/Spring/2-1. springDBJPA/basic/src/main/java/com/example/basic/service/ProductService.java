package com.example.basic.service;

import java.util.List;

import com.example.basic.model.dto.ProductDto;


public interface ProductService {
  
  void insertProduct(ProductDto productDto);
  void updateProduct(ProductDto productDto);
  void deleteProduct(String productId);
  ProductDto getProduct(String productId);
  List<ProductDto> selectAllProducts();

}

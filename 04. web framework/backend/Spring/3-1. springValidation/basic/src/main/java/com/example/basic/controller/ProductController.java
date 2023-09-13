package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.dto.ProductDto;
import com.example.basic.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping("/{productId}")
  public ProductDto getProduct(@PathVariable String productId) {
    return productService.getProduct(productId);
  }

  @PostMapping("/withoutValid")
  public ProductDto createProductWithoutValid(@RequestBody ProductDto productDto) {
    String productId = productDto.getProductId();
    String productName = productDto.getProductName();
    int productPrice = productDto.getProductPrice();
    int productStock = productDto.getProductStock();

    return productService.saveProduct(productId, productName, productPrice, productStock);
  }

  @PostMapping("/withValid")
  public ProductDto createProductWithValid(@Valid @RequestBody ProductDto productDto) {
    String productId = productDto.getProductId();
    String productName = productDto.getProductName();
    int productPrice = productDto.getProductPrice();
    int productStock = productDto.getProductStock();

    return productService.saveProduct(productId, productName, productPrice, productStock);
  }


}

package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.dto.ProductDto;
import com.example.basic.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping("/{productId}")
  public ProductDto getProduct(@PathVariable String productId) {
    log.info("getProduct");
    log.info(productId);
    return productService.getProduct(productId);
  }

  @GetMapping("/")
  public List<ProductDto> selectAllProducts() {
    log.info("selectAllProducts");
    return productService.selectAllProducts();
  }

  @PostMapping("/insert")
  public void insertProduct(@RequestBody ProductDto productDto) {
    log.info("insertProduct");
    productService.insertProduct(productDto);
  }

  @PostMapping("/update")
  public void updateProduct(@RequestBody ProductDto productDto) {
    log.info("updateProduct");
    log.info(productDto.toString());
    productService.updateProduct(productDto);
  }

  @PostMapping("/delete/{productId}")
  public void deleteProduct(@PathVariable String productId) {
    log.info("deleteProduct");
    log.info(productId);
    productService.deleteProduct(productId);
  }

}

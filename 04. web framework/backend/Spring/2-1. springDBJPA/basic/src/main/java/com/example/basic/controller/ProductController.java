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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ver1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/{productName}")
    public ProductDto findByProductName(@PathVariable String productName) {

        log.info("[ProductController][findByProductName] Start");
        return productService.findByProductName(productName);
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductDto dto) {

        productService.saveProduct(dto);
        return "저장 성공";
    }
}

package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.entity.ProductEntity;
import com.example.basic.service.ProductService;

@RestController
@RequestMapping("/ver1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    // localhost:8080/ver1/product/all
    @GetMapping("/all")
    public List<ProductEntity> selectProductAll() {

        return productService.selectProductAll();
    }

    @GetMapping("/{productPrice}/{productName}")
    public List<ProductEntity> selectProductFilter(
        @ModelAttribute ProductEntity product) {

        return productService.selectProductFilter(product);
    }
}

package com.example.basic.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
  
}

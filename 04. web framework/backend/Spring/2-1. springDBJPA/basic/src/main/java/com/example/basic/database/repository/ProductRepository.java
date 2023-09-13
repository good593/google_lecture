package com.example.basic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
  
}

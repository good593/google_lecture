package com.example.basic.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.basic.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  
  @Query(value ="SELECT u.* FROM product u WHERE u.product_id = :productId", nativeQuery= true)
  ProductEntity getEntityByProductId(@Param(value = "productId") String productId);

  
}

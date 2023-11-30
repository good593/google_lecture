package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.entity.ProductEntity;

@Mapper
public interface ProductMapper {

    List<ProductEntity> selectProductAll();
    List<ProductEntity> selectProductFilter(
        @Param("productPrice") int productPrice, 
        @Param("productName") String productName);
    ProductEntity selectProductById(@Param("productId") int productId);
    int insertProduct(ProductEntity product);
    int updateProduct(ProductEntity product);
    int deleteProduct(@Param("productId") int productId);
}

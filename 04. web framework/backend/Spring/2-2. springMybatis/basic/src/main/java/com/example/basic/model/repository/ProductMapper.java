package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.entity.ProductEntity;

@Mapper
public interface ProductMapper {

    public List<ProductEntity> selectProductAll();
    public List<ProductEntity> selectProductFilter(
        @Param("productPrice") int productPrice, 
        @Param("productName") String productName);
    public ProductEntity selectProductById(@Param("productId") int productId);
    public int insertProduct(ProductEntity product);
    public int updateProduct(ProductEntity product);
    public int deleteProduct(@Param("productId") int productId);
}

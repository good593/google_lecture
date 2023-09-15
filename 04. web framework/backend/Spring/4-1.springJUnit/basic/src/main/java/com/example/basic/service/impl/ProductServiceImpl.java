package com.example.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.database.dao.ProductDAO;
import com.example.basic.model.dto.ProductDto;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDAO productDAO;

  @Override
  public ProductDto getProduct(String productId) {
    // TODO Auto-generated method stub
    ProductEntity entity = productDAO.getProduct(productId);
    ProductDto productDto = new ProductDto(
      entity.getProductId(), entity.getProductName(), entity.getProductPrice(), entity.getProductStock()
    );

    return productDto;
  }

  @Override
  public void insertProduct(ProductDto productDto) {
    // TODO Auto-generated method stub
    log.info("insertProduct");
    ProductEntity product = new ProductEntity();
    product.setProductId(productDto.getProductId());
    product.setProductName(productDto.getProductName());
    product.setProductPrice(productDto.getProductPrice());
    product.setProductStock(productDto.getProductStock());
    
    productDAO.saveProduct(product);
  }

  @Override
  public void deleteProduct(String productId) {
    // TODO Auto-generated method stub
    productDAO.deleteProduct(productId);
  }

  @Override
  public List<ProductDto> selectAllProducts() {
    // TODO Auto-generated method stub
    List<ProductDto> productList = new ArrayList<ProductDto>();
    List<ProductEntity> productEntities = productDAO.selectAllProducts();

    for (ProductEntity entity : productEntities) {
      productList.add(new ProductDto(entity.getProductId(), entity.getProductName(), entity.getProductPrice(), entity.getProductStock()));
    }

    return productList;
  }

  @Override
  public void updateProduct(ProductDto productDto) {
    // TODO Auto-generated method stub

    ProductEntity product = new ProductEntity();
    product.setProductId(productDto.getProductId());
    product.setProductName(productDto.getProductName());
    product.setProductPrice(productDto.getProductPrice());
    product.setProductStock(productDto.getProductStock());

    productDAO.updateProduct(product);
  }
  
}

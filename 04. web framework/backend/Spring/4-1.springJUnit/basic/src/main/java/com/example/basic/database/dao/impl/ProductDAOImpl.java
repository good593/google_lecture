package com.example.basic.database.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.database.dao.ProductDAO;
import com.example.basic.database.repository.ProductRepository;
import com.example.basic.model.entity.ProductEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDAOImpl implements ProductDAO {

  // https://kimseungjae.tistory.com/11
  public static void copyNonNullProperties(Object src, Object target) {
    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
  }

  public static String[] getNullPropertyNames(Object source ) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<String>();
    for (java.beans.PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null) emptyNames.add(pd.getName());
    }

    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
  }

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ProductEntity getProduct(String productId) {
    // TODO Auto-generated method stub
    log.info("[ProductDAOImpl][getProduct] start");
    return productRepository.getEntityByProductId(productId);
  }

  @Override
  public void saveProduct(ProductEntity productEntity) {
    // TODO Auto-generated method stub
    productRepository.save(productEntity);
  }

  @Override
  public void deleteProduct(String productId) {
    // TODO Auto-generated method stub
    ProductEntity entity = productRepository.getEntityByProductId(productId);
    productRepository.deleteById(entity.getId());
  }

  @Override
  public List<ProductEntity> selectAllProducts() {
    // TODO Auto-generated method stub
    return productRepository.findAll();
  }

  @Override
  public void updateProduct(ProductEntity productEntity) {
    // TODO Auto-generated method stub
    ProductEntity existing = getProduct(productEntity.getProductId());
    // product의 변수들 중 값이 있는 것들을 existing에 업데이트!!
    copyNonNullProperties(productEntity, existing);

    productRepository.save(existing);
  }

}

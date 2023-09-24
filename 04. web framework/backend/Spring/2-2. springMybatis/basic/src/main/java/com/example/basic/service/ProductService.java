package com.example.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.MemberEntity;
import com.example.basic.repository.MemberMapper;

@Service
public class ProductService {
  
  @Autowired
  private MemberMapper productMapper;

  public List<MemberEntity> selectEntityAll(String memberName, String memberAddr) {
    return productMapper.selectEntityAll(memberName, memberAddr);
  }

  public MemberEntity selectEntityById(String memberId) {
    return productMapper.selectEntityById(memberId);
  }

  public void insertEntity(MemberEntity memberEntity) {
    productMapper.insertEntity(memberEntity);
  }

  public void updateEntity(MemberEntity memberEntity) {
    productMapper.updateEntity(memberEntity);
  }
  
  public void deleteEntity(String memberId) {
    productMapper.deleteEntity(memberId);
  }
}

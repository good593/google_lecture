package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.MemberEntity;
import com.example.basic.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping("/test")
  public String test() {
    return "Hello World";
  }

  @GetMapping("/")
  public List<MemberEntity> selectEntityAll() {
    log.info("selectEntityAll start");
    return productService.selectEntityAll(null, null);
  }

  @GetMapping("/{memberName}/{memberAddr}")
  public List<MemberEntity> selectEntityAllWithVariables(
    @PathVariable String memberName, @PathVariable String memberAddr) {
    log.info("selectEntityAllWithVariables");
    return productService.selectEntityAll(memberName, memberAddr);
  }

  @GetMapping("/{memberId}")
  public MemberEntity selectEntityById(@PathVariable String memberId) {
    log.info("selectEntityById");
    log.info(memberId);
    return productService.selectEntityById(memberId);
  }

  @PostMapping("/")
  public void insertProduct(@RequestBody MemberEntity memberEntity) {
    log.info("insertProduct");
    log.info(memberEntity.toString());
    productService.insertEntity(memberEntity);
  }

  @PostMapping("/update")
  public void updateEntity(@RequestBody MemberEntity memberEntity) {
    log.info("updateEntity");
    productService.updateEntity(memberEntity);
  }

  @PostMapping("/delete/{id}")
  public void deleteEntity(@PathVariable String memberId) {
    log.info("deleteEntity");
    productService.deleteEntity(memberId);
  }
}

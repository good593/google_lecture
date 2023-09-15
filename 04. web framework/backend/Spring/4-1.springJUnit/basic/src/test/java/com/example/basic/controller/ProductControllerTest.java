package com.example.basic.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.basic.model.dto.ProductDto;
import com.example.basic.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  public ProductServiceImpl productService;

  // http://localhost:8080/api/v1/product/{productId}
  @Test
  @DisplayName("Product 조회 테스트")
  public void getProductTest() throws Exception {

    String productId = "12345";

    // given: Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드 
    given(productService.getProduct(productId))
      .willReturn(new ProductDto("qwer", "name", 10, 20));

    // andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메소드
    mockMvc.perform(
      get("/api/v1/product/" + productId))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.productId").exists()) // json path의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex : $.productId.productIdName)
      .andExpect(jsonPath("$.productName").exists())
      .andExpect(jsonPath("$.productPrice").exists())
      .andExpect(jsonPath("$.productStock").exists())
      .andDo(print());

    // verify : 해당 객체의 메소드가 실행되었는지 체크해줌
    verify(productService).getProduct(productId);
  }

  // http://localhost:8080/api/v1/product/insert
  @Test
  @DisplayName("Product 데이터 생성 테스트")
  public void createProductTest() throws Exception {
    //Mock 객체에서 특정 메소드가 실행되는 경우 실제 Return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만들어줌
    given(productService.getProduct("15871")).willReturn(
        new ProductDto("15871", "pen", 5000, 2000));

    ProductDto productDto = ProductDto.builder().productId("15871").productName("pen")
        .productPrice(5000).productStock(2000).build();

    String json = new ObjectMapper().writeValueAsString(productDto);

    mockMvc.perform(
            post("/api/v1/product/insert")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());

  }

}

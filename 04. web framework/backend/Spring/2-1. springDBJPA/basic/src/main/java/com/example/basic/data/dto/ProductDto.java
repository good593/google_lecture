package com.example.basic.data.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
  
  private String productId;

  @NotBlank
  @Size(min = 4, max = 10)
  private String ProductName;

  @Min(value = 50)
  private int ProductPrice;

  @Min(value = 0)
  @Max(value = 99)
  private int productStock;

}

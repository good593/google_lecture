package com.example.basic.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {
    
    @NotBlank // null, "", " " 다 불가능 
    @Size(min = 2, max = 4)
    private String id;
    @NotBlank // null, "", " " 다 불가능
    @Size(min = 4, max = 8)
    private String pw;
}

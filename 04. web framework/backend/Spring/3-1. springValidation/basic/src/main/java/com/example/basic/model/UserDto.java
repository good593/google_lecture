package com.example.basic.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
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
public class UserDto {
    
    @NotBlank // null, "", " " 다 불가능 
    @Size(min = 2, max = 4)
    private String id;
    @NotBlank // null, "", " " 다 불가능
    @Size(min = 4, max = 8)
    private String pw;
    
    @NotEmpty // " " 다 가능
    private String name;
    
    @PositiveOrZero // 양수와 0만 허용
    @Max(value = 120)
    private int age;

    @Email
    private String email;

    @Pattern(regexp="^01(?:0|1|[6-9])-?\\d{3,4}-?\\d{4}$", message = "올바른 전화번로를 입력해주세요.")
    private String phoneNumber;
}

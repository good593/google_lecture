package com.example.basic.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity(name = "UserDto")
@Table(name = "custom")
public class UserDto {
    
    @Id // 기본키: 유니크 
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    // 일반사용자 / 관리자를 구분용
    private String role; 
}

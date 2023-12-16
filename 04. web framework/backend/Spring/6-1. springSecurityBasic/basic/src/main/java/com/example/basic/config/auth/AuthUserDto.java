package com.example.basic.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.basic.model.dto.UserDto;

import lombok.AllArgsConstructor;

// Spring Security가 사용할 수 있는 전용 Dto(UserDetails)를 정의함!!
// 우리가 만든 UserDto를 이용하여 UserDetails를 정의함!!
@AllArgsConstructor
public class AuthUserDto implements UserDetails {

    private UserDto userDto;

    // 권한(들)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            
            @Override
            public String getAuthority() {
                return userDto.getRole();
            }
        });
        
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userDto.getPwd();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userDto.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        // 계정 만료 유무 확인 
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        // 계정 잠긴 유무 확인
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        // 계정 비번 오래 사용했는지 유무 확인 
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        // 활성화된 계정인지 유무 확인  
        return true;
    }
    
}

package com.example.basic.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.basic.model.dto.UserDto;

import lombok.AllArgsConstructor;

// Spring Security가 이해할 수 있는 userDto는 UserDetails
// 우리가 만든 userDto를 
// Spring Security가 이해할 수 있는 UserDetails 만들어야함!
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {

    private UserDto userDto;

    // 사용자의 권한 리스트를 주입.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            
            @Override
            public String getAuthority() {
                // userDto의 권한이 추가됨.
                return userDto.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userDto.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userDto.getUsername();
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

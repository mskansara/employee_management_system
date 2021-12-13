package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetails implements UserDetails {
    public String email;
    public String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(){}
    public MyUserDetails(Employee employee) {
        this.email = employee.getCompanyEmail();
        this.password = employee.getPassword();
        this.enabled = employee.isEnabled();
        this.authorities = Arrays.stream(employee.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

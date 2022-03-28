package com.example.webshop.modules.auth.service;

import com.example.webshop.modules.auth.jpa.Auth;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class AuthAccount extends User {

    private Auth auth;

    public AuthAccount(Auth auth) {
        super(auth.getEmail(), auth.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.auth = auth;
    }
}

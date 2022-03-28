package com.example.webshop.modules.auth.service;

import com.example.webshop.modules.auth.dto.SignUpForm;
import com.example.webshop.modules.auth.jpa.Auth;
import com.example.webshop.modules.auth.jpa.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Auth newAccountCreate(SignUpForm signUpForm) {
        signUpForm.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        Auth auth = new Auth();
        auth.createAccount(signUpForm);
        return authRepository.save(auth);
    }

    @Override
    public void login(Auth auth) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new AuthAccount(auth),
                auth.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}

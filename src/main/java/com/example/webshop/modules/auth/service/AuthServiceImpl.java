package com.example.webshop.modules.auth.service;

import com.example.webshop.modules.auth.dto.SignUpForm;
import com.example.webshop.modules.auth.jpa.Auth;
import com.example.webshop.modules.auth.jpa.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Auth newAuth = authRepository.save(auth);
        
        return null;
    }
}

package com.example.webshop.modules.auth.service;

import com.example.webshop.modules.auth.dto.SignUpForm;
import com.example.webshop.modules.auth.jpa.Auth;

public interface AuthService {


    Auth newAccountCreate(SignUpForm signUpForm);
}

package com.example.webshop.modules.auth.controller;

import com.example.webshop.modules.auth.dto.SignUpForm;
import com.example.webshop.modules.auth.jpa.Auth;
import com.example.webshop.modules.auth.service.AuthService;
import com.example.webshop.modules.auth.validator.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final SignUpFormValidator signUpFormValidator;
    private final AuthService authService;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute(new SignUpForm());
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "auth/signup";
        }
        Auth auth = authService.newAccountCreate(signUpForm);

        return "redirect:/";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "auth/signin";
    }


}

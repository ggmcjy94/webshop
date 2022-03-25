package com.example.webshop.modules.auth.validator;

import com.example.webshop.modules.auth.dto.SignUpForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignUpFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SignUpForm signUpForm = (SignUpForm) object;
        if (!signUpForm.getPassword().equals(signUpForm.getConfirmPassword())) {
            errors.rejectValue("password", "invalid.password","비밀번호가 일치하지 않습니다.");
        }
    }
}

package com.example.webshop.modules.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8,max = 50)
    private String password;

    @NotBlank
    @Length(min = 8, max= 50)
    private String confirmPassword;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;


}

package com.example.webshop.modules.auth.jpa;


import com.example.webshop.modules.auth.dto.SignUpForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String name;
    private String address;
    private String phone;

    public void createAccount(SignUpForm signUpForm) {

    }
}

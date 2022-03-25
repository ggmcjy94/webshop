package com.example.webshop.modules.auth.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthRepository extends JpaRepository<Auth, Long> {
}

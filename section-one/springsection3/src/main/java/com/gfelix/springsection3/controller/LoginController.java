package com.gfelix.springsection3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.PasswordManagementConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfelix.springsection3.domain.Customer;
import com.gfelix.springsection3.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {
    
    private final CustomerRepository repository;

    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        
        if (!repository.findByEmail(customer.getEmail()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        customer.setPwd(encoder.encode(customer.getPwd()));

        var response = repository.save(customer);

        return ResponseEntity.ok().build();

    }
}

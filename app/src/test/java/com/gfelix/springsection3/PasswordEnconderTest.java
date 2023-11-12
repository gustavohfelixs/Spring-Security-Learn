package com.gfelix.springsection3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEnconderTest {

    @Test
    @DisplayName("BCryptPasswordEncoder encoding sucess - Test")
    void encondingTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        var password = "password";

        var hashPassword = encoder.encode(password);

        Assertions.assertTrue(encoder.matches(password, hashPassword));
    }
    
}

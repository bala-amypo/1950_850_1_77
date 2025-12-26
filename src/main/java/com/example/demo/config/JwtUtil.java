package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "dummy-token-" + email;
    }

    public String validateAndParse(String token) {
        return token.replace("dummy-token-", "");
    }
}

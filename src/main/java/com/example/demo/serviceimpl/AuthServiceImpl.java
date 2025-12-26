package com.example.demo.serviceimpl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginRequest login(LoginRequest request) {
        return new LoginRequest("Login successful", "dummy-token");
    }

    @Override
    public void register(RegisterRequest request) {
        // registration logic
    }
}

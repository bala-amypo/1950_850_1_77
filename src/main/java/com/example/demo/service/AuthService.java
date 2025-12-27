package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;

public interface AuthService {

    User register(RegisterRequest request);

    String login(LoginRequest request);
}

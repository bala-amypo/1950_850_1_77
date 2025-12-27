package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User register(RegisterRequest request);

    User getById(Long id);

    User findByEmail(String email);

    List<User> listInstructors();
}

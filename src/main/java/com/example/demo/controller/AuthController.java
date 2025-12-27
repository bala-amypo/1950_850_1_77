package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.config.JwtUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication APIs")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {
        User user = userService.register(req);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        User user = userService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(Map.of("token", token));
    }
}

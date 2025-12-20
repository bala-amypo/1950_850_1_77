package com.example.demo.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;

    public AuthServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User register(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return repo.save(user);
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> listInstructors() {
        return repo.findAll()
                .stream()
                .filter(u -> "INSTRUCTOR".equalsIgnoreCase(u.getRole()))
                .toList();
    }
}

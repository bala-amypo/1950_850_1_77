package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String fullName;
    private String email;
    private String password;
    private User.Role role;   // ADMIN / INSTRUCTOR / STUDENT
}

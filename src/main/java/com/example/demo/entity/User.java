package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    public enum Role {
        ADMIN,
        STUDENT,
        INSTRUCTOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    private boolean active = true;

    public boolean isActive() {
        return active;
    }
}

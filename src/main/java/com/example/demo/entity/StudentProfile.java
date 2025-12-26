package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ REQUIRED
    private String enrollmentId;

    // ✅ REQUIRED
    private String cohort;

    // ✅ REQUIRED
    private int yearLevel;

    // ✅ REQUIRED
    private boolean active;

    @OneToOne
    private User user;
}

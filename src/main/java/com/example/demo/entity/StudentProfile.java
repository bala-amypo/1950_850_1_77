package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String enrollmentId;
    private String cohort;
    private Integer yearLevel;

    private Boolean active;   // ← IMPORTANT

    private LocalDateTime lastUpdatedAt;
}

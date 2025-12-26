package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String enrollmentId;

    private String cohort;

    private int yearLevel;

    private boolean active;

    private Instant lastUpdatedAt;

    @PrePersist
    public void prePersist() {
        this.lastUpdatedAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }

    public void grade(String grade) {
        this.cohort = grade;
    }
}

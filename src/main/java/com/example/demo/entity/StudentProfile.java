package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;

    private String grade;

    private String cohort;

    private Instant lastUpdatedAt;

    @ManyToOne
    private User user;

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = Instant.now();
    }
}

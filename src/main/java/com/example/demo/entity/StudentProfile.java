package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollmentId;

    private String grade;

    private String cohort;

    private Instant lastUpdatedAt;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdatedAt = Instant.now();
    }
}

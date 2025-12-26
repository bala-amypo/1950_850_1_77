package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "student_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relationship with User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(unique = true, nullable = false)
    private String enrollmentId;

    private String cohort;

    private Integer yearLevel;

    @Builder.Default
    private boolean active = true;

    @Builder.Default
    private Instant lastUpdatedAt = Instant.now();

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}

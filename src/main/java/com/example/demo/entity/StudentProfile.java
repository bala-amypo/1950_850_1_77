package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(
        name = "student_profiles",
        uniqueConstraints = @UniqueConstraint(columnNames = "enrollmentId")
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(nullable = false, unique = true)
    private String enrollmentId;

    // REQUIRED BY TEST
    private String grade;

    private String cohort;

    private Integer yearLevel;

    @Builder.Default
    private Boolean active = true;

    @Builder.Default
    private Instant lastUpdatedAt = Instant.now();

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
}

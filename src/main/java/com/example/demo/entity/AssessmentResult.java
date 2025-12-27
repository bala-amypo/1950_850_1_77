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
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private String assessmentId;

    private Double score;

    private Double maxScore = 100.0;

    private Instant attemptedAt;

    @PrePersist
    public void prePersist() {
        if (this.maxScore == null) {
            this.maxScore = 100.0;
        }
        this.attemptedAt = Instant.now();
    }
}

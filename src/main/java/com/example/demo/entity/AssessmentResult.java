package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    private Skill skill;

    @Column(nullable = false)
    private String assessmentId;

    @Column(nullable = false)
    private Double score;

    private Double maxScore = 100.0;

    private LocalDateTime attemptedAt;

    @PrePersist
    void onCreate() {
        this.attemptedAt = LocalDateTime.now();
    }
}

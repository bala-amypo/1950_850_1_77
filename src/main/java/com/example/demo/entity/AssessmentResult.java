package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private int maxScore;

    @ManyToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    // REQUIRED for repository sorting
    private Instant attemptedAt;
}

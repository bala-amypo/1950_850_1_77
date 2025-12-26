package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {

    @Id @GeneratedValue
    private Long id;

    private Long studentProfileId;
    private Long skillId;
    private double score;
    private String assessmentId;
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillGapRecommendation {

    @Id @GeneratedValue
    private Long id;

    private Long studentId;
    private Long skillId;
    private String recommendation;
}

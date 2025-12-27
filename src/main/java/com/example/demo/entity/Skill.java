package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private Boolean active;

    private Double minCompetencyScore;

    @PrePersist
    public void prePersist() {
        if (active == null) {
            active = true;
        }
        if (minCompetencyScore == null) {
            minCompetencyScore = 0.0;
        }
    }
}

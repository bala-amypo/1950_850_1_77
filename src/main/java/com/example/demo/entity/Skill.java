package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String name;

    private String category;

    private String description;

    @Builder.Default
    private Double minCompetencyScore = 0.0;

    @Builder.Default
    private boolean active = true;
}
 
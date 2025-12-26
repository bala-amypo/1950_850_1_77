package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillGapRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Integer gapScore;
}

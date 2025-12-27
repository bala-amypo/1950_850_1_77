package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillGapRecommendationRepository
        extends JpaRepository<SkillGapRecommendation, Long> {

    List<SkillGapRecommendation>
    findByStudentProfileIdOrderByGeneratedAtDesc(Long studentProfileId);

    @Query("select r from SkillGapRecommendation r " +
           "where r.studentProfile.id = :studentId " +
           "order by r.generatedAt desc")
    List<SkillGapRecommendation> findByStudentOrdered(Long studentId);
}

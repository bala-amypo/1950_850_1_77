package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {

    double computeRecommendationsForStudentSkill(Long studentId, Long skillId);

    List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId);

    // ✅ ADD THIS
    List<SkillGapRecommendation> generateRecommendations(Long studentId);
}

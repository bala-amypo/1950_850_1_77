package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {

    SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId);

    List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId);

    void delete(Long id);
}

package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {

    SkillGapRecommendation create(SkillGapRecommendation recommendation);

    List<SkillGapRecommendation> getByStudent(Long studentId);

    void delete(Long id);
}

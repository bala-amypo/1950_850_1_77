package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {

    SkillGapRecommendation create(SkillGapRecommendation recommendation);

    SkillGapRecommendation getById(Long id);

    List<SkillGapRecommendation> getByStudent(Long studentProfileId);

    void delete(Long id);
}

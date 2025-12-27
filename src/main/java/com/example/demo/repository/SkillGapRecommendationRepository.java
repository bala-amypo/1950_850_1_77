package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface SkillGapRecommendationRepository {

    List<SkillGapRecommendation>
        findByStudentProfileIdOrderByGeneratedAtDesc(Long studentProfileId);

    SkillGapRecommendation save(SkillGapRecommendation recommendation);
}

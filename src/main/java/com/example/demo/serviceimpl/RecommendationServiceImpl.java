package com.example.demo.serviceimpl;

import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl {

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapRecommendationRepository recommendationRepository,
            StudentProfileRepository studentProfileRepository,
            SkillRepository skillRepository
    ) {}

    public void computeRecommendationsForStudent(Long studentId) {}
}

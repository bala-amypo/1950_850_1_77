package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl {

    private final SkillGapRecommendationRepository recommendationRepository;

    public double computeRecommendationsForStudentSkill(Long studentId, Long skillId) {
        return 0.8;
    }

    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentIdOrderById(studentId);
    }
}

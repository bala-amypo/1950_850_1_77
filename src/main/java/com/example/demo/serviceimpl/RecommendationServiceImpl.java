package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecordRepository skillGapRecordRepository;
    private final SkillGapRecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(
            SkillGapRecordRepository skillGapRecordRepository,
            SkillGapRecommendationRepository recommendationRepository) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        SkillGapRecord gap = skillGapRecordRepository
                .findByStudentProfileIdAndSkillId(studentId, skillId)
                .orElseThrow(() -> new RuntimeException("Skill gap not found"));

        String priority;
        if (gap.getGapScore() > 20) {
            priority = "HIGH";
        } else if (gap.getGapScore() > 10) {
            priority = "MEDIUM";
        } else {
            priority = "LOW";
        }

        SkillGapRecommendation recommendation = new SkillGapRecommendation();
        recommendation.setStudentProfile(gap.getStudentProfile());
        recommendation.setSkill(gap.getSkill());
        recommendation.setGapScore(gap.getGapScore());
        recommendation.setPriority(priority);

        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository
                .findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}

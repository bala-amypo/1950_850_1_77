package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recommendationRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recommendationRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.recommendationRepo = recommendationRepo;
    }

    @Override
    public List<SkillGapRecommendation> generateRecommendations(Long studentProfileId) {

        List<AssessmentResult> results =
                assessmentRepo.findByStudentProfileId(studentProfileId);

        List<SkillGapRecommendation> recommendations = new ArrayList<>();

        for (AssessmentResult r : results) {

            double percentage =
                    (r.getScore() * 100.0) / r.getMaxScore();

            if (percentage < 70) {
                SkillGapRecommendation rec =
                        SkillGapRecommendation.builder()
                                .studentProfile(r.getStudentProfile())
                                .skill(r.getSkill())
                                .gapScore(100 - percentage)
                                .createdAt(Instant.now())
                                .build();

                recommendations.add(
                        recommendationRepo.save(rec)
                );
            }
        }
        return recommendations;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentProfileId) {
        return recommendationRepo.findByStudentProfile_Id(studentProfileId);
    }
}

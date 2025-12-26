package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recommendationRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recommendationRepo,
            SkillRepository skillRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.recommendationRepo = recommendationRepo;
        this.skillRepo = skillRepo;
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

                Skill skill = r.getSkill();
                StudentProfile profile = r.getStudentProfile();

                SkillGapRecommendation rec =
                        SkillGapRecommendation.builder()
                                .studentProfile(profile)
                                .skill(skill)
                                .gapScore(100 - percentage)
                                .generatedAt(Instant.now())
                                .build();

                recommendations.add(
                        recommendationRepo.save(rec)
                );
            }
        }
        return recommendations;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsByStudent(Long studentProfileId) {
        return recommendationRepo.findByStudentProfileId(studentProfileId);
    }
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recommendationRepo;
    private final StudentProfileRepository studentProfileRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recommendationRepo,
            StudentProfileRepository studentProfileRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.recommendationRepo = recommendationRepo;
        this.studentProfileRepo = studentProfileRepo;
    }

    // ✅ METHOD NAME MUST MATCH INTERFACE EXACTLY
    @Override
    public List<SkillGapRecommendation> generateRecommendations(Long studentProfileId) {

        StudentProfile profile = studentProfileRepo.findById(studentProfileId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        List<AssessmentResult> results =
                assessmentRepo.findByStudentProfileId(studentProfileId);

        List<SkillGapRecommendation> recommendations = new ArrayList<>();

        for (AssessmentResult result : results) {

            if (result.getScore() < result.getMaxScore()) {

                Skill skill = result.getSkill();

                SkillGapRecommendation rec = new SkillGapRecommendation();
                rec.setStudentProfile(profile);
                rec.setSkill(skill);
                rec.setRecommendationText(
                        "Improve skill: " + skill.getName()
                );
                rec.setGeneratedAt(Instant.now());

                recommendations.add(recommendationRepo.save(rec));
            }
        }

        return recommendations;
    }
}

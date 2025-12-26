package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recommendationRepo;
    private final StudentProfileRepository profileRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recommendationRepo,
            StudentProfileRepository profileRepo,
            SkillRepository skillRepo) {
        this.assessmentRepo = assessmentRepo;
        this.recommendationRepo = recommendationRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {

        StudentProfile sp = profileRepo.findById(studentId).orElseThrow();
        Skill skill = skillRepo.findById(skillId).orElseThrow();

        List<AssessmentResult> results =
            assessmentRepo.findByStudentProfileIdAndSkillId(studentId, skillId);

        double avg = results.stream()
                .mapToDouble(r -> r.getScore() * 100 / r.getMaxScore())
                .average()
                .orElse(0);

        SkillGapRecommendation rec = SkillGapRecommendation.builder()
                .studentProfile(sp)
                .skill(skill)
                .gapScore(100 - avg)
                .generatedBy("SYSTEM")
                .build();

        return recommendationRepo.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        StudentProfile sp = profileRepo.findById(studentId).orElseThrow();
        List<Skill> skills = skillRepo.findByActiveTrue();

        List<SkillGapRecommendation> list = new ArrayList<>();
        for (Skill s : skills) {
            list.add(computeRecommendationForStudentSkill(sp.getId(), s.getId()));
        }
        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepo.findByStudentOrdered(studentId);
    }
}

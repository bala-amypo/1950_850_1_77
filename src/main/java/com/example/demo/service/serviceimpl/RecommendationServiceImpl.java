package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapRecommendationRepository recommendationRepository,
            StudentProfileRepository studentProfileRepository,
            SkillRepository skillRepository
    ) {
        this.assessmentResultRepository = assessmentResultRepository;
        this.recommendationRepository = recommendationRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long studentId,
            Long skillId
    ) {

        StudentProfile studentProfile = studentProfileRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found"));

        List<AssessmentResult> results =
                assessmentResultRepository
                        .findByStudentProfileIdAndSkillId(studentId, skillId);

        double score = results.isEmpty() ? 0 : results.get(0).getScore();
        double gap = skill.getMinCompetencyScore() - score;

        SkillGapRecommendation rec = new SkillGapRecommendation();
        rec.setStudentProfile(studentProfile);
        rec.setSkill(skill);
        rec.setGapScore(gap);

        if (gap >= 20) rec.setPriority("HIGH");
        else if (gap >= 10) rec.setPriority("MEDIUM");
        else rec.setPriority("LOW");

        rec.setRecommendedAction("Improve " + skill.getCode());

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        studentProfileRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile not found"));

        List<Skill> skills = skillRepository.findByActiveTrue();
        List<SkillGapRecommendation> list = new ArrayList<>();

        for (Skill skill : skills) {
            SkillGapRecommendation rec =
                    computeRecommendationForStudentSkill(studentId, skill.getId());
            list.add(rec);
        }

        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}

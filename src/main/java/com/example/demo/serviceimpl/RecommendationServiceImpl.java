package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

        SkillGapRecommendation rec = new SkillGapRecommendation();
        rec.setStudentProfile(gap.getStudentProfile());
        rec.setSkill(gap.getSkill());
        rec.setGapScore(gap.getGapScore());
        rec.setPriority("HIGH");
        rec.setGeneratedAt(Instant.now());

        return recommendationRepository.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentProfileId(studentId);
    }

    @Override
    public void delete(Long id) {
        recommendationRepository.deleteById(id);
    }
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;

import java.util.ArrayList;
import java.util.List;

public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository gapRepository;
    private final SkillRepository skillRepository;
    private final AssessmentResultRepository assessmentRepository;

    public SkillGapServiceImpl(
            SkillGapRecordRepository gapRepository,
            SkillRepository skillRepository,
            AssessmentResultRepository assessmentRepository) {

        this.gapRepository = gapRepository;
        this.skillRepository = skillRepository;
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public List<SkillGapRecord> calculateSkillGaps(Long studentProfileId) {

        List<Skill> skills = skillRepository.findByActiveTrue();
        List<SkillGapRecord> records = new ArrayList<>();

        for (Skill skill : skills) {

            List<AssessmentResult> results =
                    assessmentRepository.findByStudentProfileIdAndSkillId(
                            studentProfileId, skill.getId());

            double avgScore = results.isEmpty()
                    ? 0
                    : results.stream()
                             .mapToDouble(AssessmentResult::getScoreObtained)
                             .average()
                             .orElse(0);

            double target = skill.getMinCompetencyScore() != null
                    ? skill.getMinCompetencyScore()
                    : 100;

            SkillGapRecord record = SkillGapRecord.builder()
                    .gapScore(target - avgScore)
                    .currentScore(avgScore)
                    .targetScore(target)
                    .skill(skill)
                    .build();

            records.add(gapRepository.save(record));
        }

        return records;
    }
}

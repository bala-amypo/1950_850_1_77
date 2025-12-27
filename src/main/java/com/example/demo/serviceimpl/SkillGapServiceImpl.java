package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {


    private final SkillGapRecordRepository gapRepo;
    private final SkillRepository skillRepo;
    private final AssessmentResultRepository assessmentRepo;

    // ⚠️ EXACT constructor order (critical)
    public SkillGapServiceImpl(
            SkillGapRecordRepository gapRepo,
            SkillRepository skillRepo,
            AssessmentResultRepository assessmentRepo) {

        this.gapRepo = gapRepo;
        this.skillRepo = skillRepo;
        this.assessmentRepo = assessmentRepo;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecord> records = new ArrayList<>();

        for (Skill skill : skills) {

            List<AssessmentResult> results =
                    assessmentRepo.findByStudentProfileIdAndSkillId(
                            studentProfileId, skill.getId());

            double currentScore = results.isEmpty()
                    ? 0.0
                    : results.get(results.size() - 1).getScore();

            double targetScore =
                    skill.getMinCompetencyScore() == null
                            ? 0.0
                            : skill.getMinCompetencyScore();

            double gap = Math.max(0, targetScore - currentScore);

            SkillGapRecord record = SkillGapRecord.builder()
                    .studentProfile(
                            StudentProfile.builder().id(studentProfileId).build())
                    .skill(skill)
                    .currentScore(currentScore)
                    .targetScore(targetScore)
                    .gapScore(gap)
                    .build();

            records.add(gapRepo.save(record));
        }

        return records;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentProfileId) {
        return gapRepo.findByStudentProfileId(studentProfileId);
    }
}

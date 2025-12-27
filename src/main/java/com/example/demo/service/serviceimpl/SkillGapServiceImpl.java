package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository skillGapRecordRepository;
    private final SkillRepository skillRepository;
    private final AssessmentResultRepository assessmentResultRepository;

    public SkillGapServiceImpl(
            SkillGapRecordRepository skillGapRecordRepository,
            SkillRepository skillRepository,
            AssessmentResultRepository assessmentResultRepository
    ) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.skillRepository = skillRepository;
        this.assessmentResultRepository = assessmentResultRepository;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {

        List<Skill> skills = skillRepository.findByActiveTrue();
        List<SkillGapRecord> records = new ArrayList<>();

        for (Skill skill : skills) {
            List<AssessmentResult> results =
                    assessmentResultRepository.findByStudentProfileIdAndSkillId(
                            studentProfileId, skill.getId());

            if (results.isEmpty()) continue;

            AssessmentResult latest = results.get(0);

            SkillGapRecord record = new SkillGapRecord();
            record.setSkill(skill);
            record.setCurrentScore(latest.getScore());
            record.setTargetScore(skill.getMinCompetencyScore());
            record.setGapScore(skill.getMinCompetencyScore() - latest.getScore());

            records.add(skillGapRecordRepository.save(record));
        }

        return records;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentProfileId) {
        return skillGapRecordRepository.findByStudentProfileId(studentProfileId);
    }
}

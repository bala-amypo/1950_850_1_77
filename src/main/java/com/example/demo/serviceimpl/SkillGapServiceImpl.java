package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository skillGapRecordRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    public SkillGapServiceImpl(
            SkillGapRecordRepository skillGapRecordRepository,
            StudentProfileRepository studentProfileRepository,
            SkillRepository skillRepository
    ) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecord calculateGap(
            Long studentProfileId,
            Long skillId,
            Double currentScore
    ) {
        StudentProfile studentProfile = studentProfileRepository
                .findById(studentProfileId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Skill skill = skillRepository
                .findById(skillId)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

        Double targetScore = skill.getMinCompetencyScore();
        Double gapScore = targetScore - currentScore;

        SkillGapRecord record = new SkillGapRecord();
        record.setStudentProfile(studentProfile);
        record.setSkill(skill);
        record.setCurrentScore(currentScore);
        record.setTargetScore(targetScore);
        record.setGapScore(gapScore);

        return skillGapRecordRepository.save(record);
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentProfileId) {
        return skillGapRecordRepository.findByStudentProfileId(studentProfileId);
    }

    // ✅ THIS METHOD FIXES YOUR CURRENT COMPILATION ERROR
    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {

        StudentProfile studentProfile = studentProfileRepository
                .findById(studentProfileId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        List<Skill> skills = skillRepository.findAll();
        List<SkillGapRecord> results = new ArrayList<>();

        for (Skill skill : skills) {
            SkillGapRecord record = new SkillGapRecord();
            record.setStudentProfile(studentProfile);
            record.setSkill(skill);
            record.setCurrentScore(0.0);
            record.setTargetScore(skill.getMinCompetencyScore());
            record.setGapScore(skill.getMinCompetencyScore());

            results.add(skillGapRecordRepository.save(record));
        }

        return results;
    }
}

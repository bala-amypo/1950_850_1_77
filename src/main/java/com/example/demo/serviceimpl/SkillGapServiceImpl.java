package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository skillGapRecordRepository;

    public SkillGapServiceImpl(SkillGapRecordRepository skillGapRecordRepository) {
        this.skillGapRecordRepository = skillGapRecordRepository;
    }

    @Override
    public List<SkillGapRecord> getSkillGaps(Long studentId) {
        return skillGapRecordRepository.findByStudentProfileId(studentId);
    }
}

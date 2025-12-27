package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecord;
import java.util.List;

public interface SkillGapRecordRepository {

    List<SkillGapRecord> findByStudentProfileId(Long studentProfileId);

    SkillGapRecord save(SkillGapRecord record);
}

package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillGapRecordRepository
        extends JpaRepository<SkillGapRecord, Long> {

    Optional<SkillGapRecord> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);
}

package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    List<AssessmentResult> findByStudentProfileId(Long studentId);

    Optional<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);
}

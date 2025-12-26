package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.*;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {

    List<AssessmentResult> findByStudentProfileId(Long id);

    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);

    Optional<AssessmentResult>
    findTopByStudentProfileIdAndSkillIdOrderByAttemptedAtDesc(Long studentId, Long skillId);

    Double avgScoreByCohortAndSkill(String cohort, Long skillId);

    List<AssessmentResult> findRecentByStudent(Long studentId);

    List<AssessmentResult> findResultsForStudentBetween(Long studentId, Instant from, Instant to);
}

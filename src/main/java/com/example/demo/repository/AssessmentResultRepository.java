package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    // Used in many tests
    List<AssessmentResult> findByStudentProfileIdAndSkillId(
            Long studentProfileId,
            Long skillId
    );

    // 🔥 FIXED: Explicit JPQL (prevents startup crash)
    @Query("""
        select avg(a.score)
        from AssessmentResult a
        where a.studentProfile.cohort = :cohort
          and a.skill.id = :skillId
    """)
    Double avgScoreByCohortAndSkill(
            @Param("cohort") String cohort,
            @Param("skillId") Long skillId
    );

    // Used in tests
    @Query("""
        select a
        from AssessmentResult a
        where a.studentProfile.id = :studentId
        order by a.attemptedAt desc
    """)
    List<AssessmentResult> findRecentByStudent(
            @Param("studentId") Long studentId
    );

    // Used in tests
    @Query("""
        select a
        from AssessmentResult a
        where a.studentProfile.id = :studentId
          and a.attemptedAt between :start and :end
    """)
    List<AssessmentResult> findResultsForStudentBetween(
            @Param("studentId") Long studentId,
            @Param("start") Instant start,
            @Param("end") Instant end
    );
}

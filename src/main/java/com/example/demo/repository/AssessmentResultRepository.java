package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentResultRepository {

    AssessmentResult save(AssessmentResult result);

    List<AssessmentResult> findByStudentProfileId(Long studentProfileId);

    List<AssessmentResult> findByStudentProfileIdAndSkillId(
            Long studentProfileId,
            Long skillId
    );
}

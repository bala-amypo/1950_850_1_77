package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentService {

    AssessmentResult recordAssessment(AssessmentResult result);

    List<AssessmentResult> getResultsByStudent(Long studentProfileId);

    // 🔴 THIS METHOD EXISTS — MUST BE IMPLEMENTED
    List<AssessmentResult> getResultsByStudentAndSkill(
            Long studentProfileId,
            Long skillId
    );
}

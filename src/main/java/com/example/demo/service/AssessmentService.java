package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentService {

    AssessmentResult create(AssessmentResult result);

    List<AssessmentResult> getByStudent(Long studentId);

    AssessmentResult getByStudentAndSkill(Long studentId, Long skillId);
}

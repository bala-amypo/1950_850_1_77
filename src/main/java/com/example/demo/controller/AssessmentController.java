package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public AssessmentResult record(@RequestBody AssessmentResult result) {
        return service.recordAssessment(result);
    }

    @GetMapping("/student/{studentId}")
    public List<AssessmentResult> byStudent(@PathVariable Long studentId) {
        return service.getResultsByStudent(studentId);
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public List<AssessmentResult> byStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {
        return service.getResultsByStudentAndSkill(studentId, skillId);
    }
}

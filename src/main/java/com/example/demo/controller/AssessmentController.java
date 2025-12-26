package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    // CREATE assessment
    @PostMapping
    public AssessmentResult create(@RequestBody AssessmentResult result) {
        return service.create(result);
    }

    // GET all assessments by student
    @GetMapping("/student/{studentId}")
    public List<AssessmentResult> getByStudent(@PathVariable Long studentId) {
        return service.getByStudent(studentId);
    }

    // GET assessment by student + skill (SINGLE result)
    @GetMapping("/student/{studentId}/skill/{skillId}")
    public AssessmentResult getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {
        return service.getByStudentAndSkill(studentId, skillId);
    }
}

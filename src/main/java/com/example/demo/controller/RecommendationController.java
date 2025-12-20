package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping
    public SkillGapRecommendation create(@RequestBody SkillGapRecommendation r) {
        return service.create(r);
    }

    @GetMapping("/student/{studentId}")
    public List<SkillGapRecommendation> getByStudent(
            @PathVariable Long studentId) {
        return service.getByStudent(studentId);
    }
}

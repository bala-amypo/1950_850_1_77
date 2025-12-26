package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{studentProfileId}")
    public List<SkillGapRecommendation> getRecommendations(
            @PathVariable Long studentProfileId
    ) {
        // ✅ CORRECT METHOD NAME
        return service.generateRecommendations(studentProfileId);
    }
}

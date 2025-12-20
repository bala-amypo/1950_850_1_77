package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repo;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repo) {
        this.repo = repo;
    }

    public SkillGapRecommendation create(SkillGapRecommendation recommendation) {
        return repo.save(recommendation);
    }

    public SkillGapRecommendation getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recommendation not found"));
    }

    public List<SkillGapRecommendation> getByStudent(Long studentProfileId) {
        return repo.findByStudentProfileIdOrderByGeneratedAtDesc(studentProfileId);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repository;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillGapRecommendation create(SkillGapRecommendation recommendation) {
        return repository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> getByStudent(Long studentId) {
        return repository.findByStudentProfileId(studentId);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

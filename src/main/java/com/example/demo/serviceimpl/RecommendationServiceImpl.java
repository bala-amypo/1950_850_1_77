package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final SkillGapRecommendationRepository repo;

    public RecommendationServiceImpl(SkillGapRecommendationRepository repo) {
        this.repo = repo;
    }

    @Override
    public SkillGapRecommendation create(SkillGapRecommendation rec) {
        rec.setGeneratedAt(LocalDateTime.now());
        return repo.save(rec);
    }

    @Override
    public List<SkillGapRecommendation> getByStudent(Long studentProfileId) {
        return repo.findByStudentProfileId(studentProfileId);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

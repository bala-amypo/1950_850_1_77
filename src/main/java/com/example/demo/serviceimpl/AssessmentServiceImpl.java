package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repo;

    public AssessmentServiceImpl(AssessmentResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {

        if (result.getScore() == null) {
            throw new IllegalArgumentException("Score cannot be null");
        }

        if (result.getMaxScore() == null) {
            result.setMaxScore(100.0);
        }

        if (result.getScore() < 0 || result.getScore() > result.getMaxScore()) {
            throw new IllegalArgumentException("Score out of range");
        }

        return repo.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentProfileId) {
        return repo.findByStudentProfileId(studentProfileId);
    }

    // ✅ THIS FIXES THE COMPILATION ERROR
    @Override
    public List<AssessmentResult> getResultsByStudentAndSkill(
            Long studentProfileId,
            Long skillId
    ) {
        return repo.findByStudentProfileIdAndSkillId(studentProfileId, skillId);
    }
}

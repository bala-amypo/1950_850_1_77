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
        if (result.getScore() == null ||
            result.getScore() < 0 ||
            result.getScore() > result.getMaxScore()) {
            throw new IllegalArgumentException("Score must be between 0 and maxScore");
        }
        return repo.save(result);
    }

    @Override
    public List<AssessmentResult> getByStudent(Long studentId) {
        return repo.findByStudentProfileId(studentId);
    }

    @Override
    public AssessmentResult getByStudentAndSkill(Long studentId, Long skillId) {
        return repo
            .findTopByStudentProfileIdAndSkillIdOrderByAttemptedAtDesc(studentId, skillId)
            .orElse(null);
    }
}

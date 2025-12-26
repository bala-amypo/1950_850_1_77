package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.exception.ResourceNotFoundException;
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
        return repo.save(result);
    }

    @Override
    public List<AssessmentResult> getByStudent(Long studentProfileId) {
        return repo.findByStudentProfileId(studentProfileId);
    }

    @Override
    public AssessmentResult getByStudentAndSkill(Long studentId, Long skillId) {
        return repo.findTopByStudentProfileIdAndSkillIdOrderByAttemptedAtDesc(studentId, skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
    }
}

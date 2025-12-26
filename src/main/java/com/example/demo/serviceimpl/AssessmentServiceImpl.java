package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {
        result.setAttemptedAt(Instant.now());
        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getByStudent(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }

    @Override
    public AssessmentResult getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("AssessmentResult not found"));
    }
}

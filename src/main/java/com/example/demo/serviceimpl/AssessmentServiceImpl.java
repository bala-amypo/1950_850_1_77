package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentService;

import java.util.List;

public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {

        if (result.getScoreObtained() == null ||
            result.getMaxScore() == null ||
            result.getScoreObtained() < 0 ||
            result.getScoreObtained() > result.getMaxScore()) {

            throw new IllegalArgumentException("Invalid score");
        }

        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsForStudent(Long studentProfileId) {
        return repository.findByStudentProfileId(studentProfileId);
    }
}

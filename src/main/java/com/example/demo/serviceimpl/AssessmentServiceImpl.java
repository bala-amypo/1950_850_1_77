package com.example.demo.serviceimpl;

import com.example.demo.repository.AssessmentResultRepository;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl {

    public AssessmentServiceImpl(
            AssessmentResultRepository assessmentResultRepository
    ) {}
}

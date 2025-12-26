package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;

import java.util.List;

public interface AssessmentService {

    AssessmentResult create(AssessmentResult result);

    List<AssessmentResult> getAll();

    AssessmentResult getById(Long id);
}

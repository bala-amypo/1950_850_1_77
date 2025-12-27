package com.example.demo.serviceimpl;

import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class SkillGapServiceImpl {

    public SkillGapServiceImpl(
            AssessmentResultRepository assessmentResultRepository,
            SkillGapRecordRepository skillGapRecordRepository
    ) {}
}

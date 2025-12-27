package com.example.demo.service;

import com.example.demo.entity.SkillGapRecord;

import java.util.List;

public interface SkillGapService {

    SkillGapRecord calculateGap(
            Long studentProfileId,
            Long skillId,
            Double currentScore
    );

    List<SkillGapRecord> getGapsByStudent(Long studentProfileId);

    // 🔴 REQUIRED METHOD (WAS MISSING IN IMPL)
    List<SkillGapRecord> computeGaps(Long studentProfileId);
}

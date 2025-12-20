package com.example.demo.service;

import com.example.demo.entity.SkillGapRecord;
import java.util.List;

public interface SkillGapService {

    SkillGapRecord create(SkillGapRecord record);

    SkillGapRecord getById(Long id);

    List<SkillGapRecord> getByStudent(Long studentProfileId);

    void delete(Long id);
}

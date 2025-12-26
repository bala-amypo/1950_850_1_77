package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.SkillGapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository repository;

    @Override
    public List<SkillGapRecord> getByStudent(Long studentProfileId) {
        return repository.findByStudentProfile_Id(studentProfileId);
    }
}

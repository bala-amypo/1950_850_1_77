package com.example.demo.serviceimpl;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository repo;

    public SkillGapServiceImpl(SkillGapRecordRepository repo) {
        this.repo = repo;
    }

    public SkillGapRecord create(SkillGapRecord record) {
        return repo.save(record);
    }

    public SkillGapRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SkillGapRecord not found"));
    }

    public List<SkillGapRecord> getByStudent(Long studentProfileId) {
        return repo.findByStudentProfileId(studentProfileId);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}

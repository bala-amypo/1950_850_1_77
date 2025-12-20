package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentResultServiceImpl implements AssessmentResultService {

    private final AssessmentResultRepository repo;

    public AssessmentResultServiceImpl(AssessmentResultRepository repo) {
        this.repo = repo;
    }

    public AssessmentResult create(AssessmentResult result) {
        return repo.save(result);
    }

    public List<AssessmentResult> getByStudent(Long studentProfileId) {
        return repo.findByStudentProfileId(studentProfileId);
    }

    public List<AssessmentResult> getByStudentAndSkill(Long studentProfileId, Long skillId) {
        return repo.findByStudentProfileIdAndSkillId(studentProfileId, skillId);
    }
}

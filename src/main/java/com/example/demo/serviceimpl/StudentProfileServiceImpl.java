package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile create(StudentProfile profile) {
        return repo.save(profile);
    }

    public StudentProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found"));
    }

    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    public StudentProfile update(Long id, StudentProfile profile) {
        StudentProfile existing = getById(id);
        existing.setEnrollmentId(profile.getEnrollmentId());
        existing.setCohort(profile.getCohort());
        existing.setYearLevel(profile.getYearLevel());
        existing.setActive(profile.getActive());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}

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

    @Override
    public StudentProfile create(StudentProfile profile) {
        return repo.save(profile);
    }

    @Override
    public StudentProfile update(Long id, StudentProfile profile) {
        StudentProfile existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        existing.setEnrollmentId(profile.getEnrollmentId());
        existing.setCohort(profile.getCohort());
        existing.setYearLevel(profile.getYearLevel());
        existing.setActive(profile.isActive());

        return repo.save(existing);
    }

    @Override
    public StudentProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ❗ EXTRA METHOD – NO @Override
    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}

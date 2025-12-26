package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repo.save(profile);
    }

    // ✅ REQUIRED BY INTERFACE
    @Override
    public StudentProfile update(Long id, StudentProfile profile) {
        StudentProfile existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        existing.setEnrollmentId(profile.getEnrollmentId());
        existing.setGrade(profile.getGrade());

        return repo.save(existing);
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    // ✅ REQUIRED BY INTERFACE
    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Profile not found");
        }
        repo.deleteById(id);
    }
}

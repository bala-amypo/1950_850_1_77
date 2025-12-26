package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
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
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repo.save(profile);
    }

    // ✅ MISSING METHOD – NOW ADDED
    @Override
    public StudentProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public StudentProfile update(Long id, StudentProfile profile) {
        StudentProfile existing = getById(id);
        existing.setEnrollmentId(profile.getEnrollmentId());
        existing.setGrade(profile.getGrade());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Profile not found");
        }
        repo.deleteById(id);
    }
}

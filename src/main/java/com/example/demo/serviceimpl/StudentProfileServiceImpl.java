package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

import java.util.List;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repo.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found"));
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found"));
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repo.findByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found"));
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repo.findAll();
    }
}

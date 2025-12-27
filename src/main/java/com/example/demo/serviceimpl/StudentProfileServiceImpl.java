package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile getByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile not found"));
    }

    @Override
    public StudentProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile not found"));
    }
}

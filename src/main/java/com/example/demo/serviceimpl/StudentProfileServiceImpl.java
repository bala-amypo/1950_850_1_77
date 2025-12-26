package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl {

    private final StudentProfileRepository repository;

    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        profile.setLastUpdatedAt(System.currentTimeMillis());
        return repository.save(profile);
    }
}

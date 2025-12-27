package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    @Override
    public StudentProfile create(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile update(Long id, StudentProfile profile) {
        StudentProfile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));

        existing.setName(profile.getName());
        existing.setEmail(profile.getEmail());
        existing.setCourse(profile.getCourse());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public StudentProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }
}

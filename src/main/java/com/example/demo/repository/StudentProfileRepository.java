package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import java.util.Optional;

public interface StudentProfileRepository {

    Optional<StudentProfile> findById(Long id);

    Optional<StudentProfile> findByEnrollmentId(String enrollmentId);

    StudentProfile save(StudentProfile profile);
}

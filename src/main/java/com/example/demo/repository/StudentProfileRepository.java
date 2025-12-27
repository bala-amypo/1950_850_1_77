package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByEnrollmentId(String enrollmentId);
    Optional<StudentProfile> findByUserId(Long userId);
    boolean existsByEnrollmentId(String enrollmentId);
}

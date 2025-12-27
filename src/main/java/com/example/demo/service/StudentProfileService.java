package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile create(StudentProfile profile);

    StudentProfile update(Long id, StudentProfile profile);

    void delete(Long id);

    StudentProfile getById(Long id);

    List<StudentProfile> getAll();
}

package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile profile) {
        return service.createOrUpdateProfile(profile);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getProfileById(id);
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public StudentProfile getByEnrollment(@PathVariable String enrollmentId) {
        return service.getProfileByEnrollmentId(enrollmentId);
    }

    @GetMapping
    public List<StudentProfile> all() {
        return service.getAllProfiles();
    }
}

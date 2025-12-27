package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile createProfile(@RequestBody StudentProfile profile) {
        return service.createOrUpdateProfile(profile);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public StudentProfile getByEnrollmentId(@PathVariable String enrollmentId) {
        return service.getByEnrollmentId(enrollmentId);
    }
}

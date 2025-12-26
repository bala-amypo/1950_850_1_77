package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.service.SkillGapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-gaps")
@RequiredArgsConstructor
public class SkillGapController {

    private final SkillGapService service;

    @GetMapping("/{studentId}")
    public List<SkillGapRecord> getByStudent(@PathVariable Long studentId) {
        return service.getByStudent(studentId);
    }
}

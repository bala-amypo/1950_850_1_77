package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.service.SkillGapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gaps")
@Tag(name = "Skill Gaps")
public class SkillGapController {

    private final SkillGapService service;

    public SkillGapController(SkillGapService service) {
        this.service = service;
    }

    @PostMapping
    public SkillGapRecord create(@RequestBody SkillGapRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public SkillGapRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<SkillGapRecord> getByStudent(@PathVariable Long studentId) {
        return service.getByStudent(studentId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

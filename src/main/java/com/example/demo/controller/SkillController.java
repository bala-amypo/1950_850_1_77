package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skills", description = "Skill Management APIs")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.updateSkill(id, skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAll() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
        return ResponseEntity.noContent().build();
    }
}

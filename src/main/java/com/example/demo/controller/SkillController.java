package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return service.create(skill);
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) {
        return service.update(id, skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

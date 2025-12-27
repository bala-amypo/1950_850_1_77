package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        if (repository.findBySkillName(skill.getSkillName()).isPresent()) {
            throw new IllegalArgumentException("Skill already exists");
        }
        return repository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill updatedSkill) {
        Skill skill = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found"));

        skill.setCategory(updatedSkill.getCategory());
        skill.setDescription(updatedSkill.getDescription());
        skill.setMinCompetencyScore(updatedSkill.getMinCompetencyScore());

        return repository.save(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found"));
    }

    @Override
    public List<Skill> getActiveSkills() {
        return repository.findByActiveTrue();
    }
}

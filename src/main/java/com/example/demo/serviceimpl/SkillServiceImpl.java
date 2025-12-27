package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        if (repo.findByCode(skill.getCode()).isPresent()) {
            throw new IllegalArgumentException("unique");
        }
        return repo.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        existing.setName(skill.getName());
        return repo.save(existing);
    }

    @Override
    public Skill getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<Skill> getAllSkills() {
        return repo.findAll();
    }

    @Override
    public List<Skill> getActiveSkills() {
        return repo.findByActiveTrue();
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill s = getById(id);
        s.setActive(false);
        repo.save(s);
    }
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl {

    private final SkillRepository repository;

    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }
}

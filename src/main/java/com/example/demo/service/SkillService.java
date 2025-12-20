package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {
    Skill create(Skill skill);
    Skill getById(Long id);
    List<Skill> getAll();
    Skill update(Long id, Skill skill);
    void delete(Long id);
}

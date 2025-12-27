package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    List<Skill> getAllSkills();

    Skill getSkillById(Long id);

    Skill updateSkill(Long id, Skill skill);

    void deleteSkill(Long id);
}

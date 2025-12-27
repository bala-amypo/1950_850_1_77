package com.example.demo.repository;

import com.example.demo.entity.Skill;
import java.util.List;
import java.util.Optional;

public interface SkillRepository {

    Optional<Skill> findById(Long id);

    Optional<Skill> findBySkillName(String skillName);

    List<Skill> findByActiveTrue();

    Skill save(Skill skill);
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ THIS WAS MISSING
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = getSkillById(id);
        existing.setName(skill.getName());
        existing.setDescription(skill.getDescription());
        existing.setActive(skill.isActive());
        return skillRepository.save(existing);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}

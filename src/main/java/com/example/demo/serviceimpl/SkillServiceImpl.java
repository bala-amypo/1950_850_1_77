// package com.example.demo.serviceimpl;

// import com.example.demo.entity.Skill;
// import com.example.demo.repository.SkillRepository;
// import com.example.demo.service.SkillService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class SkillServiceImpl implements SkillService {

//     private final SkillRepository repo;

//     public SkillServiceImpl(SkillRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public Skill createSkill(Skill skill) {
//         return repo.save(skill);
//     }

//     @Override
//     public List<Skill> getAllSkills() {
//         return repo.findAll();
//     }
// 

package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        existing.setName(skill.getName());
        existing.setDescription(skill.getDescription());
        return repository.save(existing);
    }

    @Override
    public Skill getSkillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public List<Skill> getActiveSkills() {
        return repository.findAll();
    }
}

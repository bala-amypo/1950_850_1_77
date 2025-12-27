package com.example.demo.serviceimpl;

import com.example.demo.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl {

    public SkillServiceImpl(SkillRepository skillRepository) {}

    public void deactivateSkill(Long id) {}
}

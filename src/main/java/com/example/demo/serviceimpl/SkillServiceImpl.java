package com.example.demo.serviceimpl;

import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Override
    public String test() {
        return "Skill service working";
    }
}

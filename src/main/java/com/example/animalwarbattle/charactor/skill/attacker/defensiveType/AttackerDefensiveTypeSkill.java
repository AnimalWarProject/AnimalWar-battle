package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerDefensiveTypeSkill {


    void defensiveTypeAttackerExecute (Character attacker, Character defender);

}



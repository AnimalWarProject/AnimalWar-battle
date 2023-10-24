package com.example.animalwarbattle.charactor.skill.defender.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderDefensiveTypeSkill {

    void defensiveTypeDefenderExecute (Character attacker, Character defender);
}



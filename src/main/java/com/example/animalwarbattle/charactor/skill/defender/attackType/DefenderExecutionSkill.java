package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderExecutionSkill {
    Integer execution(Character attacker, Character defender);
}

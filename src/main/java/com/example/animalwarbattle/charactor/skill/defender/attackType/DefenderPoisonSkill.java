package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderPoisonSkill {
    Integer poison(Character attacker, Character defender);
}

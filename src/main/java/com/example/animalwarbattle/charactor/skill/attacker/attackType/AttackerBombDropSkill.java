package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;
@Component
public interface AttackerBombDropSkill {
    Integer bombDrop(Character attacker, Character defender);
}

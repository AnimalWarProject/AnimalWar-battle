package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

public interface AttackerExecutionSkill {
    Integer execution(Character attacker, Character defender);
}

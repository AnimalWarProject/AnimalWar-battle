package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerUtilityTypeSkill {

    void utilityTypeAttackerExecute (Character attacker, Character defender);

}



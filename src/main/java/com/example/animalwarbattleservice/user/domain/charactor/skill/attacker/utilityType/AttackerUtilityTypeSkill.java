package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerUtilityTypeSkill {


    void utilityTypeAttackerBrokenShield (Character attacker, Character defender);
    void utilityTypeAttackerBrokenSpear (Character attacker, Character defender);
    void utilityTypeAttackerDoItAgain (Character attacker, Character defender);
    void utilityTypeAttackerOffenseDefenseShift (Character attacker, Character defender);
    void utilityTypeAttackerStrongAndWeak (Character attacker, Character defender);
    void utilityTypeAttackerSwap (Character attacker, Character defender);

}



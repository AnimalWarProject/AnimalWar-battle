package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderUtilityTypeSkill {


    void utilityTypeDefenderBrokenShield (Character attacker, Character defender);
    void utilityTypeDefenderBrokenSpear (Character attacker, Character defender);
    void utilityTypeDefenderDoItAgain (Character attacker, Character defender);
    void utilityTypeDefenderOffenseDefenseShift (Character attacker, Character defender);
    void utilityTypeDefenderStrongAndWeak (Character attacker, Character defender);
    void utilityTypeDefenderSwap (Character attacker, Character defender);

}



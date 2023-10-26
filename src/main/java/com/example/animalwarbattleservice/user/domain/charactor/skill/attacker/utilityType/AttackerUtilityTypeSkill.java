package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerUtilityTypeSkill {


    void utilityTypeAttackerBrokenShield (CharacterDto attacker, CharacterDto defender);
    void utilityTypeAttackerBrokenSpear (CharacterDto attacker, CharacterDto defender);
    void utilityTypeAttackerDoItAgain (CharacterDto attacker, CharacterDto defender);
    void utilityTypeAttackerOffenseDefenseShift (CharacterDto attacker, CharacterDto defender);
    void utilityTypeAttackerStrongAndWeak (CharacterDto attacker, CharacterDto defender);
    void utilityTypeAttackerSwap (CharacterDto attacker, CharacterDto defender);

}



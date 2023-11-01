package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface UtilityTypeSkill {



    void execute (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerBrokenShield (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerBrokenSpear (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerDoItAgain (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerOffenseDefenseShift (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerStrongAndWeak (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeAttackerSwap (CharacterDto attacker, CharacterDto defender);

}



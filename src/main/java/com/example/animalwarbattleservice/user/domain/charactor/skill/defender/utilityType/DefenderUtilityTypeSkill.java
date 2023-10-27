package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefenderUtilityTypeSkill {


    void execute (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderBrokenShield (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderBrokenSpear (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderDoItAgain (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderOffenseDefenseShift (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderStrongAndWeak (CharacterDto attacker, CharacterDto defender);
//    void utilityTypeDefenderSwap (CharacterDto attacker, CharacterDto defender);

}



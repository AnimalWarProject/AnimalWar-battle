package com.example.animalwarbattle.charactor.skill.defender.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderUtilityTypeSkill {


    void UtilityTypeDefenderExecute (Character attacker, Character defender);

}



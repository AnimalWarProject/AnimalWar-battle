package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface UtilityTypeSkill {
    void execute (CharacterDto attacker, CharacterDto defender);
}



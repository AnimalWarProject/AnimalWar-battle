package com.example.animalwarbattleservice.user.domain.character.skill.utilityType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface UtilityTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}



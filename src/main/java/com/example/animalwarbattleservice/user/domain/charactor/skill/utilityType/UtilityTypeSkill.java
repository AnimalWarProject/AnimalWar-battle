package com.example.animalwarbattleservice.user.domain.charactor.skill.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface UtilityTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}



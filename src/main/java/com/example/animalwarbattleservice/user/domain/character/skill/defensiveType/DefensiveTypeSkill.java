package com.example.animalwarbattleservice.user.domain.character.skill.defensiveType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefensiveTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}



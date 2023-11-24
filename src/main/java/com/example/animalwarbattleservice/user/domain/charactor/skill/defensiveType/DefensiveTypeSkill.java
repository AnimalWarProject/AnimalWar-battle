package com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefensiveTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}



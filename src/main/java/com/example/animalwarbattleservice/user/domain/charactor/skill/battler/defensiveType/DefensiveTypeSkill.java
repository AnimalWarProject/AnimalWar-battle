package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefensiveTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}



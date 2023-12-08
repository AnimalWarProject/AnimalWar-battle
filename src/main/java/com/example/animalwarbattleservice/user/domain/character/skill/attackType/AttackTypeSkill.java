package com.example.animalwarbattleservice.user.domain.character.skill.attackType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}






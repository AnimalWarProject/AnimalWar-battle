package com.example.animalwarbattleservice.user.domain.charactor.skill.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}






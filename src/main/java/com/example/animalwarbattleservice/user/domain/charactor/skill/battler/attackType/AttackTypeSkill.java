package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackTypeSkill {
    Integer execute (CharacterDto attacker, CharacterDto defender);
}






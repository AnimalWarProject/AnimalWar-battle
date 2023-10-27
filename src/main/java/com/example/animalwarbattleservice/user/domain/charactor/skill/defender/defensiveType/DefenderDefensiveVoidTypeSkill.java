package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefenderDefensiveVoidTypeSkill {
    void execute (CharacterDto attacker, CharacterDto defender);
}



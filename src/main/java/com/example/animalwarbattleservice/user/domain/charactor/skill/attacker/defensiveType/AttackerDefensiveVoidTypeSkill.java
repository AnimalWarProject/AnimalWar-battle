package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerDefensiveVoidTypeSkill {
    void execute (CharacterDto attacker, CharacterDto defender);

}



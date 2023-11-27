package com.example.animalwarbattleservice.user.domain.charactor.basicAttack;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface BasicDefender {
    Integer plainDef(CharacterDto attacker, CharacterDto defender);
}
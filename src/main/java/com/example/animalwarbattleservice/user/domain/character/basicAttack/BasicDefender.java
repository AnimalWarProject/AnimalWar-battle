package com.example.animalwarbattleservice.user.domain.character.basicAttack;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface BasicDefender {
    Integer plainDef(CharacterDto attacker, CharacterDto defender);
}
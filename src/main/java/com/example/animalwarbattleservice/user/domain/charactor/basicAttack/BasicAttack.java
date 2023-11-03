package com.example.animalwarbattleservice.user.domain.charactor.basicAttack;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface BasicAttack {
    Integer plainHit(CharacterDto attacker, CharacterDto defender);
}
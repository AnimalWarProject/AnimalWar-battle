package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerBasicAttack {
    Integer attackPlainHit(CharacterDto attacker, CharacterDto defender);
}

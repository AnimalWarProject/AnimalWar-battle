package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;
@Component
public interface DefenderBasicAttack {
    Integer defendPlainHit(CharacterDto attacker, CharacterDto defender);
}

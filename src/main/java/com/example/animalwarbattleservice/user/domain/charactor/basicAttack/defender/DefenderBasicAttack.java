package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;
@Component
public interface DefenderBasicAttack {
    Integer defendPlainHit(CharacterDto attacker, CharacterDto defender);
}

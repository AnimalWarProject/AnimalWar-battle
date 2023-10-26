package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;
@Component
public interface DefenderBasicAttack {
    void defendPlainHit(Character attacker, Character defender);
}

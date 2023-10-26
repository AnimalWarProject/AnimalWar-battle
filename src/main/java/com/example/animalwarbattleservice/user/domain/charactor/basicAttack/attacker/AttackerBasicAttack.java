package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerBasicAttack {
    void attackPlainHit(Character attacker, Character defender);
}

package com.example.animalwarbattle.charactor.basicAttack.attacker;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface BasicAttack {
    void attackPlainHit(Character attacker, Character defender);
}

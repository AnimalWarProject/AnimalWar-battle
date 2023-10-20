package com.example.animalwarbattle.charactor.basicAttack.attacker;

import com.example.animalwarbattle.charactor.domain.entity.Character;

public interface BasicAttack {
    Integer attackPlainHit(Character attacker, Character defender);
}

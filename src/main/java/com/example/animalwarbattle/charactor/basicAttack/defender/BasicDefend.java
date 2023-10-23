package com.example.animalwarbattle.charactor.basicAttack.defender;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;
@Component
public interface BasicDefend {
    Integer defendPlainHit(Character attacker, Character defender);
}

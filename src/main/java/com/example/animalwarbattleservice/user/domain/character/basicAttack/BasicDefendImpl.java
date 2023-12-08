package com.example.animalwarbattleservice.user.domain.character.basicAttack;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public class BasicDefendImpl implements BasicDefender {

    @Override
    public Integer plainDef(CharacterDto attacker, CharacterDto defender) {
        if(attacker.isBasicAttack() != 0){
            return 0;
        }

        Integer battlePlainHit = attacker.getDefensePower();
        return battlePlainHit;
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public class DefenderBasicAttackImpl implements DefenderBasicAttack {

    @Override
    public Integer defendPlainHit(CharacterDto attacker, CharacterDto defender) {
        // 기본공격 가능 여부
        if(!defender.isBasicAttack()){
            return 0;
        }

        // 수비자 기본공격 설정
        Integer defenderPlainHit = defender.getAttackerPower();

        return defenderPlainHit;
    }
}
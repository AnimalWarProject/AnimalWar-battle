package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefenderBasicAttackImpl implements DefenderBasicAttack {

    @Override
    public void defendPlainHit(Character attacker, Character defender) {
        // 기본공격 가능 여부
        if(!defender.isBasicAttack()){
            return;
        }

        // 수비자 기본공격 설정
        int defenderPlainHit = defender.getAttackerPower();
    }
}

package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttackerBasicAttackImpl implements AttackerBasicAttack {

    @Override
    public void attackPlainHit(Character attacker, Character defender) {
        // 기본공격 가능여부
        if(!attacker.isBasicAttack()){
            return;
        }

        // 공격자 기본공격 설정
        int attackerPlainHit = attacker.getAttackerPower();
    }
}
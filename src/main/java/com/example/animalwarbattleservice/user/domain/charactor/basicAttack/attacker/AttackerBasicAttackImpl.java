package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;

public class AttackerBasicAttackImpl implements AttackerBasicAttack {

    @Override
    public Integer attackPlainHit(CharacterDto attacker, CharacterDto defender) {
        // 기본공격 가능여부
        if(!attacker.isBasicAttack()){
            return 0;
        }
        // 공격자 기본공격 설정
        Integer attackerPlainHit = attacker.getAttackerPower();

        return attackerPlainHit;
    }


}
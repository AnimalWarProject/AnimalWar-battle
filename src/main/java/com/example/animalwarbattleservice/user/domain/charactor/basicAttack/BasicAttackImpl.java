package com.example.animalwarbattleservice.user.domain.charactor.basicAttack;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;


@Component
public class BasicAttackImpl implements BasicAttack {

    @Override
    public Integer plainHit(CharacterDto attacker, CharacterDto defender) {
        // 기본공격 가능여부
        if(!attacker.isBasicAttack()){
            return 1;
        }
        // 공격자 기본공격 설정
        Integer battlePlainHit = attacker.getBattlePower();

        return battlePlainHit;
    }
}
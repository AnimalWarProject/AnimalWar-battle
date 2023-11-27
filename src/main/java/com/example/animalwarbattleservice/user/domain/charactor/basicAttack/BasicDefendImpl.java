package com.example.animalwarbattleservice.user.domain.charactor.basicAttack;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import org.springframework.stereotype.Component;

/* 기본공격: 공격력 또는 수비력으로 상대를 공격 */
@Component
public class BasicDefendImpl implements BasicDefender {

    @Override
    public Integer plainDef(CharacterDto attacker, CharacterDto defender) {
        // 기본공격 가능여부
        if(attacker.isBasicAttack() != 0){
            return 0;
        }

        // 공격자 기본공격 설정
        Integer battlePlainHit = attacker.getDefensePower();

        return battlePlainHit;
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;//package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;

///*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
public class DefenderPoisonImpl implements DefenderAttackTypeSkill {


    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()) {
            return true;
        }
        return false;
    }

    /* 독약-(1회성)상대방의 최대 체력의 7%에 해당하는 데미지를 입힙니다. */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }

        // 공격자 최대체력 설정
        int attackerMaxLife = attacker.getMaxLife();

        // 독약 스킬 설정
        Integer defenderPoisonDamage = attackerMaxLife;
        if (percentage(70)){
            defenderPoisonDamage = (int) (0.07 * attackerMaxLife);
        }
        return defenderPoisonDamage;
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;


import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;

public class AttackerHiddenAceImpl implements AttackerAttackTypeSkill {
    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()) {
            return true;
        }
        return false;
    }

    /*비장의 한발-(1회성)다음 1회의 공격이 상대방보다 체력이 적다면 5배의 피해를 입힙니다.(자신의 체력이 더 많다면 추가피해는 없습니다.)  */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if (!attacker.isAttackSkill()) {
            return 0;
        }

        // 공격자 현재체력 설정
        int attackerLife = defender.getLife();
        // 수비자 현재체력 설정
        int defenderLife = defender.getLife();
        // 비장의 한발 스킬 설정
        Integer attackerHiddenAceDamage = attacker.getAttackerPower();
        if ((attackerLife < defenderLife) && percentage(45)) {
            attackerHiddenAceDamage = 5 * (attacker.getAttackerPower());
        }
        return attackerHiddenAceDamage;
    }
}
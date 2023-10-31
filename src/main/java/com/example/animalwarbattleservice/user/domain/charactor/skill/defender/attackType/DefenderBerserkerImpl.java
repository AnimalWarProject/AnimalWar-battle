package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

    /* 버서커-(1회성)자신의 체력이 20% 이하일 때, 상대에게 입히는 데미지가 3.5배가 됩니다. */
public class DefenderBerserkerImpl implements DefenderAttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }
        // 버서커 스킬 조건
        Integer defenderBerserkerDamage = defender.getDefensePower();

        // 수비자 현재체력 및 최대체력 설정
        int defenderLife = defender.getLife();
        int defenderMaxLife = defender.getMaxLife();

        // 버서커 스킬 (확률 발동)
        if ((defenderLife <= defenderMaxLife / 5) && percentage(70)) {
            defenderBerserkerDamage = (int) 3.5 * (defenderBerserkerDamage);
        }
        return defenderBerserkerDamage;
    }
}
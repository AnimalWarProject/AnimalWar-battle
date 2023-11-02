package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;


///*  빨리감기 : 상대방과 자신의 현재 체력이 30% 감소합니다.  */
public class SpeedRunImpl implements AttackTypeSkill {

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
        if(!attacker.isAttackSkill()){
            return 0;
        }

        // 수비자 현재체력 설정
        int defenderLife = defender.getLife();
        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 빨리감기 스킬(확률 발동)
        if (percentage(99)) { //
            int attackerSpeedRun = (int) (attackerLife * 0.7);
            int defenderSpeedRun = (int) (defenderLife * 0.7);
            attacker.changeLife(attackerSpeedRun);
            defender.changeLife(defenderSpeedRun);
        }
        return 0;
    }
}
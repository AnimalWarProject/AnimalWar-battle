package com.example.animalwarbattleservice.user.domain.character.skill.attackType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/*  빨리감기 : 상대방과 자신의 현재 체력이 30% 감소합니다.  */
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
        Integer skillUsedCheck = 0;
        if(!attacker.isAttackSkill()){
            return 0;
        }

        int defenderLife = defender.getLife();
        int attackerLife = attacker.getLife();
        if (percentage(85)) { //
            int attackerSpeedRun = (int) (attackerLife * 0.7);
            int defenderSpeedRun = (int) (defenderLife * 0.7);
            attacker.changeLife(attackerSpeedRun);
            defender.changeLife(defenderSpeedRun);
        } else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}
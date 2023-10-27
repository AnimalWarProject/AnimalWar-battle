package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;//package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import java.util.Random;

    /* 빨리감기-(1회성) 상대방과 자신의 현재 체력이 30% 감소합니다. */
public class DefenderSpeedRunImpl implements DefenderAttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()) {
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

        // 수비자 현재체력 설정
        int defenderLife = defender.getLife();
        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 빨리감기 스킬(확률 발동)
        if (percentage(85)){
            int AttackerSpeedRun = (int) (attackerLife - attackerLife * 0.7);
            int DefenderSpeedRun = (int) (defenderLife - defenderLife * 0.7);
        }
        return null;
    }
}
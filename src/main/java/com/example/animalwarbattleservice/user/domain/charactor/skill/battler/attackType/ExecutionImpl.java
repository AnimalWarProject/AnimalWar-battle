package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import java.util.Random;

public class ExecutionImpl implements AttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    /* 처형-다음 5회의 공격 이내 상대방이 10%의 체력 아래라면 처형합니다. */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부


        if (!attacker.isAttackSkill()) {
            return 1;
        }

        // 처형스킬 설정
        if (percentage(99)) {
            attacker.getExecutionSkillCount();
        } else if (attacker.getExecutionSkillCount() > 0 ) {
            if (defender.getLife() <= defender.getMaxLife() / 10) {
                defender.changeLife(0);
            }
            attacker.decrementExecutionCount();
        }
        return null;
    }
}
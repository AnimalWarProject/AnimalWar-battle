package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;//package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;


    /* 처형-다음 5회의 공격 이내 상대방이 10%의 체력 아래라면 처형합니다. */
public class DefenderExecutionImpl implements DefenderAttackTypeSkill {

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

        // 처형스킬 설정
        if (percentage(45)){
            defender.getExecutionSkillCount();
        } else if (defender.getExecutionSkillCount() > 0) {
            if (attacker.getLife() <= attacker.getLife() / 10) {
                attacker.changeLife(0);
            }
        }
        return null;
    }
}
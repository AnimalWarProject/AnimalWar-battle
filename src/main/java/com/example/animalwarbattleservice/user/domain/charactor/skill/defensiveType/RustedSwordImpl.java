package com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/* 녹슨 방패: .(지속성)모든 데미지 10% 데미지 감소 */
public class RustedSwordImpl implements DefensiveTypeSkill{

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

        if (!attacker.isDependSkill()) {
            return 1;
        }

        if (percentage(100)){
            attacker.setRustedSwordActivated(true);
        }
        else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}

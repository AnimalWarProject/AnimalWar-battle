package com.example.animalwarbattleservice.user.domain.character.skill.utilityType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/* 다시하기-(1회성)상대방과 자신의 체력을 100% 회복합니다. */
public class DoItAgainImpl implements UtilityTypeSkill {

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
        Integer skillUsedCheck = 0;
        // 다시하기 스킬 사용(확률 발동)
        if(percentage(10)){
            attacker.restoreHP();
            defender.restoreHP();
        }
        else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}
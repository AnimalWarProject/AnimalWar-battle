package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType;//package com.example.animalwarbattle.charactor.skill.defender.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 다시하기-(1회성)상대방과 자신의 체력을 100% 회복합니다. */
public class DefenderDoItAgainImpl implements DefenderUtilityTypeSkill{
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
    public void execute(CharacterDto attacker, CharacterDto defender) {
        // 다시하기 스킬 사용(확률 발동)
        if(percentage(10)){
            attacker.restoreHP();
            defender.restoreHP();
        }
    }
}

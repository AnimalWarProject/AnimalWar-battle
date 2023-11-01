package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;


/* 부러진 창-(지속성)상대방이 공격형 스킬을 사용하지 못하게 합니다. */
public class BrokenSpearImpl implements UtilityTypeSkill {
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
    public void execute(CharacterDto attacker, CharacterDto defender) {
        // 부러진 창 스킬(확률 발동)
        if(percentage(99)){
            defender.blockAttackSkill();
        }
    }
}
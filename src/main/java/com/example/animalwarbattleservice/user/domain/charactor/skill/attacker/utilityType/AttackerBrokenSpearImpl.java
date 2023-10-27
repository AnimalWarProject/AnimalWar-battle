package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;

import java.util.Random;


/* 부러진 창-(지속성)상대방이 공격형 스킬을 사용하지 못하게 합니다. */
public class AttackerBrokenSpearImpl implements AttackerUtilityTypeSkill{
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
        // 부러진 창 스킬(확률 발동)
        if(percentage(10)){
            defender.blockAttackSkill();
        }
    }
}
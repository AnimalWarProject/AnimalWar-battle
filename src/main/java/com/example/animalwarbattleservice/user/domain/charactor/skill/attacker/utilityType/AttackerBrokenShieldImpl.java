package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 부러진 방패-(지속성)상대방이 방어형 스킬을 사용하지 못하게 합니다. */
public class AttackerBrokenShieldImpl implements AttackerUtilityTypeSkill {
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
        // 부러진 방패 스킬(확률 발동)
        if (percentage(10)) {
            defender.blockDependSkill();
        }
    }
}
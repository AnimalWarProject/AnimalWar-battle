package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 바꿔치기-(1회성)상대방과 자신의 체력을 교체합니다.(교체 후 자신은 현재 체력의 10%의 피해를 받습니다. */
public class AttackerSwapImpl implements AttackerUtilityTypeSkill{

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
        // 바꿔치기 스킬 사용(확률 발동)
        if(percentage(10)){
            int attackerLife = attacker.getLife();
            attacker.changeLife((int) (defender.getLife()*0.9));
            defender.changeLife(attackerLife);
        }
    }
}
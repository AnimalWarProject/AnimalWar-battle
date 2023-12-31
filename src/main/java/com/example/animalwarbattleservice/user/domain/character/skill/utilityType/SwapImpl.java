package com.example.animalwarbattleservice.user.domain.character.skill.utilityType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/* 바꿔치기-(1회성)상대방과 자신의 체력을 교체합니다.(교체 후 자신은 현재 체력의 10%의 피해를 받습니다. */
public class SwapImpl implements UtilityTypeSkill {

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
        // 바꿔치기 스킬 사용(확률 발동)
        if(percentage(10)){
            int battleLife = attacker.getLife();
            attacker.changeLife((int) (defender.getLife()*0.9));
            defender.changeLife(battleLife);
        }
        else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}
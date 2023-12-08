package com.example.animalwarbattleservice.user.domain.character.skill.utilityType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/* 공수교대-(지속성)스킬 사용 후부터 공격자는 방어력으로, 수비자는 공격력으로 전투합니다. */
public class OffenseDefenseShiftImpl implements UtilityTypeSkill {

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
        // 공수교대 사용(확률 발동)
        if(percentage(10)){
            attacker.exchangeAtkDef();
        }
        else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}
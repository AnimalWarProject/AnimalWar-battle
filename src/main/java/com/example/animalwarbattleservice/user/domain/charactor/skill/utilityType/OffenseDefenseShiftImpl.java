package com.example.animalwarbattleservice.user.domain.charactor.skill.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;

import java.util.ArrayList;
import java.util.List;
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
    public void execute(CharacterDto attacker, CharacterDto defender) {
        // 공수교대 사용(확률 발동)
        if(percentage(10)){
            attacker.exchangeAtkDef();
        }
    }
}
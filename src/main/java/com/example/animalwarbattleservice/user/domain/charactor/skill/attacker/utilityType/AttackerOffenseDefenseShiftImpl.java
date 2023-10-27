package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;

import java.util.Random;

/* 공수교대-(지속성)스킬 사용 후부터 공격자는 방어력으로, 수비자는 공격력으로 전투합니다. */
public class AttackerOffenseDefenseShiftImpl implements AttackerUtilityTypeSkill{
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
        // 공수교대 사용(확률 발동)
        if(percentage(10)){
            attacker.exchangeAtkDef();
            defender.exchangeAtkDef();
        }
    }
}
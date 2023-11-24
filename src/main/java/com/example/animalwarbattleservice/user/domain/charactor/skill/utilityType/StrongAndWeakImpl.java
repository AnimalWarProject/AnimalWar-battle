package com.example.animalwarbattleservice.user.domain.charactor.skill.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;

import java.util.Random;

/* 강약약강-(지속성)상대방보다 최대 체력이 많다면, 공격력 및 방어력이 10% 증가하고,
(최대 체력이 상대방보다 적다면, 공격력 및 방어력이 10% 감소합니다. */
public class StrongAndWeakImpl implements UtilityTypeSkill {

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
        // 강약약강 스킬(확률 발동)
        if (percentage(99)) {
            
            if (attacker.getMaxLife() > defender.getMaxLife()) {
                attacker.changeBattlePower((int) (attacker.getAttackPower() * 1.1));
            } else {
                attacker.changeBattlePower((int) (attacker.getAttackPower() * 0.9));
            }
        }
    }
}
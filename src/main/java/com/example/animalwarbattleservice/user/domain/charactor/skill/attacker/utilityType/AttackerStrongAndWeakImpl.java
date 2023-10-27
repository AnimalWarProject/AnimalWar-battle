package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType;//package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;

/* 강약약강-(지속성)상대방보다 최대 체력이 많다면, 공격력 및 방어력이 10% 증가하고,
(최대 체력이 상대방보다 적다면, 공격력 및 방어력이 10% 감소합니다. */
public class AttackerStrongAndWeakImpl implements AttackerUtilityTypeSkill{

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
        // 강약약강 스킬(확률 발동)
        if (percentage(10)) {
            if (attacker.getMaxLife() > defender.getMaxLife()) {
                attacker.changeAtkp((int) (attacker.getAttackerPower() * 1.1));
                attacker.changeDef((int) (attacker.getDefensePower() * 1.1));
            } else {
                attacker.changeAtkp((int) (attacker.getAttackerPower() * 0.9));
                attacker.changeDef((int) (attacker.getDefensePower() * 0.9));
            }
        }
    }
}
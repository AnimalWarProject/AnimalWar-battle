package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType;//package com.example.animalwarbattle.charactor.skill.defender.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import java.util.Random;

/* 강약약강-(지속성)상대방보다 최대 체력이 많다면, 공격력 및 방어력이 10% 증가하고, (최대 체력이 상대방보다 적다면, 공격력 및 방어력이 10% 감소합니다. */
public class DefenderStrongAndWeakImpl implements DefenderUtilityTypeSkill {
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
            if (defender.getMaxLife() > attacker.getMaxLife()) {
                defender.changeAtkp((int) (defender.getAttackerPower() * 1.1));
                defender.changeDef((int) (defender.getDefensePower() * 1.1));
            } else {
                defender.changeAtkp((int) (defender.getAttackerPower() * 0.9));
                defender.changeDef((int) (defender.getDefensePower() * 0.9));
            }
        }
    }
}
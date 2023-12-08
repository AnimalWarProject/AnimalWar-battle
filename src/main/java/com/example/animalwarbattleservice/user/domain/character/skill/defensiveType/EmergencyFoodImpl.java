package com.example.animalwarbattleservice.user.domain.character.skill.defensiveType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/*  비상식량 : 전투시 전체 체력의 20%를 회복합니다. */
public class EmergencyFoodImpl implements DefensiveTypeSkill {

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
        // 스킬 가능 여부
        if (!attacker.isDependSkill()) {
            return 1;
        }

        int battleLife = 0;
        // 비상식량 스킬(확률 발동)
        if (percentage(50)) {
            int emergencyFood = (int) (0.2 * attacker.getMaxLife());
            int newLife = Math.min(attacker.getMaxLife(), attacker.getLife() + emergencyFood);
            attacker.changeLife(newLife);
        }
        else {
            battleLife = -1;
        }
        return battleLife;
    }
}
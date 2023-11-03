package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
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

        // 공격자 현재 체력 설정
        int battleLife = attacker.getLife();

        // 비상식량 스킬(확률 발동)
        if (percentage(99)) {
            int emergencyFood = (int) (0.2 * attacker.getMaxLife());
            int newLife = Math.min(attacker.getMaxLife(), battleLife + emergencyFood);
            attacker.changeLife(newLife);
        }
        return attacker.getLife();
    }
}
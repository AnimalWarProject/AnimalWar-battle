package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;


///*  비상식량 : 전투시 전체 체력의 20%를 회복합니다. */
public class AttackerEmergencyFoodImpl implements AttackerDefensiveTypeSkill {

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
            return 0;
        }

        // 공격자 현재 체력 설정
        int attackerLife = attacker.getLife();

        // 비상식량 스킬(확률 발동)
        Integer attackerEmergencyFood = attacker.getMaxLife() + attackerLife;
        if (percentage(70)) {
            attackerEmergencyFood = (int) (0.2 * attacker.getMaxLife() + attackerLife);
        }
        return attackerEmergencyFood;
    }
}
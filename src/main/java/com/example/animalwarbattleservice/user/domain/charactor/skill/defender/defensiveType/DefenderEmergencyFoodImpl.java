package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;//package com.example.animalwarbattle.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;

import java.util.Random;

/* 비상식량-전투시 전체 체력의 20%를 회복 */
public class DefenderEmergencyFoodImpl implements DefenderDefensiveTypeSkill{

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
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if(!defender.isDependSkill()){
            return 0;
        }

        // 수비자 현재 체력 설정
        int defenderLife = defender.getLife();

        // 비상식량 스킬(확률 발동)
        Integer defenderEmergencyFood = defender.getMaxLife() + defenderLife;
        if (percentage(70)){
            defenderEmergencyFood = (int) (0.2 * defender.getMaxLife() + defenderLife);
        }
        return defenderEmergencyFood;
    }
}

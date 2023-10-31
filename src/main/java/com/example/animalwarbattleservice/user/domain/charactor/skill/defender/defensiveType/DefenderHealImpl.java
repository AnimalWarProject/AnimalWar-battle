package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;//package com.example.animalwarbattle.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 힐-전투시 잃은 체력의 30%를 회복 */
public class DefenderHealImpl implements DefenderDefensiveTypeSkill{

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
        // 스킬 여부
        if(!defender.isDependSkill()){
            return 0;
        }

        // 비상식량 스킬 발동 설정 및 공격자 현재 잃은 체력, 현재 체력
        int defenderLostLife = defender.getMaxLife() - defender.getLife();
        int defenderLife = defender.getLife();

        // 힐 스킬(확률 발동)
        Integer defenderHealSkill = defenderLostLife + defenderLife;
        if (percentage(65)){
            defenderHealSkill= (int) ((0.3 * defenderLostLife) + defenderLife);
        }
        return defenderHealSkill;
    }
}
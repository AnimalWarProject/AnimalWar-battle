package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import java.util.Random;

/* 럭키7 : 현재 체력이 77% 이상일 경우, 7%확률로 상대 공격을 7회 무효화 합니다. */
public class LuckySevenImpl implements DefensiveTypeSkill {

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

        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 럭키 7 스킬 발동
        if ((attackerLife >= attacker.getMaxLife() * 0.77) && percentage(7)) {
            if (defender.getLuckySevenSkillCount() > 0) {
                defender.changeBasicAttack(7);
            }
        }
        return null;
    }
}
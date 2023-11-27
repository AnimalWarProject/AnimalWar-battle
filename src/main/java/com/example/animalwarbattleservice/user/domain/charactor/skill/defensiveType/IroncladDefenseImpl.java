package com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/* 철통방어 : 상대 공격을 3회 무효화합니다. */
public class IroncladDefenseImpl implements DefensiveTypeSkill {
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
        Integer skillUsedCheck = 0;
        if (!attacker.isDependSkill()) {
            return 1;
        }

        // 철통방어 스킬(확률 발동)
        if (percentage(35)) {

            if (defender.getIroncladDefenseSkillCount() > 0) {
                defender.changeBasicAttack(3);
            }
        }
        else {
            skillUsedCheck = -1;
        }
        return skillUsedCheck;
    }
}
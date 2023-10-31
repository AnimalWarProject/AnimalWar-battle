package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;//package com.example.animalwarbattle.charactor.skill.defender.defensiveType;


import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 철통방어-상대 공격을 3회 무효화 */
public class DefenderIroncladDefenseImpl implements DefenderDefensiveTypeSkill {

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
        if (!defender.isDependSkill()) {
            return 0;
        }

        // 철통방어 스킬(확률 발동)
        if (percentage(50)){
            attacker.getIroncladDefenseSkillCount();
            attacker.blockBasicAttack();
        } else if (attacker.getIroncladDefenseSkillCount() > 0) {
            attacker.blockBasicAttack();
            attacker.decrementIroncladDefenseCount();
        }
        return null;
    }
}
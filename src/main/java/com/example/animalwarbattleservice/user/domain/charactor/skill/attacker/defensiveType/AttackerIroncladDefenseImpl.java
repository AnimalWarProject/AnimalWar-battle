package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 철통방어 : 상대 공격을 3회 무효화합니다. */
public class AttackerIroncladDefenseImpl implements AttackerDefensiveTypeSkill {
    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }
    /* 철통방어-상대 공격을 3회 무효화 */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if (!attacker.isDependSkill()) {
            return 0;
        }

        // 철통방어 스킬(확률 발동)
        if (percentage(50)) {
            defender.getIroncladDefenseSkillCount();
            defender.blockBasicAttack();
        } else if (defender.getIroncladDefenseSkillCount() > 0) {
            defender.blockBasicAttack();
            defender.decrementIroncladDefenseCount();
        }
        return null;
    }
}
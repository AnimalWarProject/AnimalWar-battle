package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

/* 럭키7 : 현재 체력이 77% 이상일 경우, 7%확률로 상대 공격을 7회 무효화 합니다. */
public class AttackerLuckySevenImpl implements AttackerDefensiveVoidTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()) {
            return true;
        }
        return false;
    }
    /* 럭키7-상대 기본공격을 7회 무효화 */
    @Override
    public void execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if (!attacker.isDependSkill()) {
            return;
        }

        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 럭키 7 스킬 발동
        if ((attackerLife >= attacker.getMaxLife() * 0.77) && percentage(7)) {
            defender.getLuckySevenSkillCount();
            defender.blockBasicAttack();
        }
    }
}
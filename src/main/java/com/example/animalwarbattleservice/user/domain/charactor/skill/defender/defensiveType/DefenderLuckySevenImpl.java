package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;//package com.example.animalwarbattle.charactor.skill.defender.defensiveType;


import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;

import java.util.Random;

public class DefenderLuckySevenImpl implements DefenderDefensiveVoidTypeSkill{
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
        if (!defender.isDependSkill()) {
            return;
        }

        // 공격자 현재체력 설정
        int defenderLife = defender.getLife();
        // 럭키 7 스킬 발동
        if ((defenderLife >= defender.getMaxLife() * 0.77) && percentage(7)) {
            attacker.getLuckySevenSkillCount();
            attacker.blockBasicAttack();
        }
    }
}
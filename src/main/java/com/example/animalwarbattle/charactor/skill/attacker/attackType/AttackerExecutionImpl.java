package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  처형 : 공격 5회 이내, 상대방이 10%의 체력 미만이라면 처형합니다.  */

public class AttackerExecutionImpl implements AttackerAttackTypeSkill {

    @Override
    public void attackTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double executionProbability = 0.5;
        Random random = new Random();

        // 1. 스킬 사용(확률 발동)
        if (random.nextDouble() < executionProbability){
        attacker.setAttackSkillCount(5);
        } else {
            System.out.println("Execution skill failed");
        }
    }
}

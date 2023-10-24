package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderExecutionImpl implements DefenderAttackTypeSkill {

    @Override
    public void attackTypeDefenderExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double executionProbability = 0.5;
        Random random = new Random();

        // 1. 스킬 사용(확률 발동)
        if (random.nextDouble() < executionProbability){
        defender.setAttackSkillCount(5);
        }  {
            System.out.println("Execution skill failed");
        }
    }
}

package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderSpeedRunImpl implements DefenderAttackTypeSkill {

    @Override
    public void defendTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double speedRunProbability = 0.85;
        Random random = new Random();

        // 1. 스피드런 스킬 발동 설정
        // 공격자, 수비자 체력 설정
        int defenderLife = defender.getLife();
        int attackerLife = attacker.getLife();

        int attackerRemainingHealth;
        int defenderRemainingHealth;

        // 1-1. 스피드런 발동
        double damagePercentage = 0.7;
        int attackerSpeedRunDamage = (int) (damagePercentage * attackerLife);
        int defenderSpeedRunDamage = (int) (damagePercentage * defenderLife);

        // 2. 스킬 사용 (확률 발동)
        if (random.nextDouble() < speedRunProbability) {
        attackerRemainingHealth = attackerLife - attackerSpeedRunDamage;
        attacker.setLife(attackerRemainingHealth);

        defenderRemainingHealth = defenderLife - defenderSpeedRunDamage;
        defender.setLife(defenderRemainingHealth);
        } else {
            System.out.println("SpeedRun skill failed");
        }
    }
}

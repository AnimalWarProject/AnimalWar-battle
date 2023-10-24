package com.example.animalwarbattle.charactor.skill.defender.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderHealImpl implements DefenderDefensiveTypeSkill{
    @Override
    public void defensiveTypeDefenderExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double poisonProbability = 0.7;
        Random random = new Random();
        // 1. 비상식량 스킬 발동 설정
        // 잃은 체력
        int defenderLostLife = defender.getMaxLife() - defender.getLife();
        // 공격자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;
        // 1-1. 힐 스킬 발동 설정
        int defenderHealSkill = (int) ((0.3 * defenderLostLife) + defenderLife);

        // 2. 스킬 발동(확률 발동)
        if (random.nextDouble() < poisonProbability) {
            remainingHealth = defenderHealSkill + defenderLife;
            defender.setLife(remainingHealth);
        } else {
            System.out.println("Heal skill failed");
        }

    }
}

package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  힐 : 전투시 잃은 체력의 30%를 회복합니다.  */
public class AttackerHealImpl implements AttackerDefensiveTypeSkill {
    @Override
    public void defensiveTypeAttackerExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double poisonProbability = 0.7;
        Random random = new Random();
        // 1. 비상식량 스킬 발동 설정
        // 잃은 체력
        int attackerLostLife = attacker.getMaxLife() - attacker.getLife();
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;
        // 1-1. 힐 스킬 발동 설정
        int attackerHealSkill = (int) ((0.3 * attackerLostLife) + attackerLife);

        // 2. 스킬 발동(확률 발동)
        if (random.nextDouble() < poisonProbability) {
            remainingHealth = attackerHealSkill + attackerLife;
            attacker.setLife(remainingHealth);
        } else {
            System.out.println("Heal skill failed");
        }
    }
}

package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  비상식량 : 전투시 전체 체력의 20%를 회복합니다. */
public class AttackerEmergencyFoodImpl implements AttackerDefensiveTypeSkill{
    @Override
    public void defensiveTypeAttackerExecute(Character attacker, Character defender) {
        
        // 0. 스킬 확률
        double poisonProbability = 0.7;
        // 1. 비상식량 스킬 발동 설정
        // 공격자 체력 설정
        Random random = new Random();
        int attackerLife = attacker.getLife();
        int remainingHealth;
        
        // 1-1. 비상식량 스킬 발동 설정
        int attackEmergencyFood = (int) (0.2 * attacker.getMaxLife());

        if (random.nextDouble() < poisonProbability){
            remainingHealth = attackerLife + attackEmergencyFood;
            attacker.setLife(remainingHealth);
        } else {
            System.out.println("Heal Poison skill failed");
        }

    }
}

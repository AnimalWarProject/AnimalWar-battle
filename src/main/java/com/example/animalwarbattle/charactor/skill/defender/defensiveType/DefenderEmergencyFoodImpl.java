package com.example.animalwarbattle.charactor.skill.defender.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderEmergencyFoodImpl implements DefenderDefensiveTypeSkill{
    @Override
    public void defensiveTypeDefenderExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double poisonProbability = 0.7;
        // 1. 비상식량 스킬 발동 설정
        // 수비자 체력 설정
        Random random = new Random();
        int defenderLife = defender.getLife();
        int remainingHealth;

        // 1-1. 비상식량 스킬 발동 설정
        int defendEmergencyFood = (int) (0.2 * defender.getMaxLife());
        if (random.nextDouble() < poisonProbability){
            remainingHealth = defenderLife + defendEmergencyFood;
            defender.setLife(remainingHealth);
        } else {
            System.out.println("Heal Poison skill failed");
        }

    }
}
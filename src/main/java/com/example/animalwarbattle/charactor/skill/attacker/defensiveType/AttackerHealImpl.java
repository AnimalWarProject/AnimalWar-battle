package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  힐 : 전투시 잃은 체력의 30%를 회복합니다.  */
public class AttackerHealImpl implements AttackerDefensiveTypeSkill{
    @Override
    public void defensiveTypeAttackerExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double poisonProbability = 0.7;
        Random random = new Random();
        // 1. 비상식량 스킬 발동 설정
        // 잃은 체력
        int AttackerLostLife = attacker.getMaxLife() - attacker.getLife();
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;
        // 1-1. 
    }
}

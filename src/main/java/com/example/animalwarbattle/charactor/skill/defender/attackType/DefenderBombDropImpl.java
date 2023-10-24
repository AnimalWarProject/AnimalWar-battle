package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderBombDropImpl implements DefenderAttackTypeSkill {

    @Override
    public void defendTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double bombDropProbability = 0.65;
        Random random = new Random();
        // 1. 폭탄 투하 스킬 발동 및 상성 체크
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;
        
        // 1-1. 폭탄 투하 발동
        int bombDropDamage = (int) (1.1 * attacker.getLife());

        // 2. 스킬 사용
        if (random.nextDouble() < bombDropProbability) {
        remainingHealth = attackerLife - bombDropDamage;
        attacker.setLife(remainingHealth);
        } else {
            System.out.println("BombDrop skill failed");
        }

        // 3. 공격자 체력 0이하 승리
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 == 수비 성공");
        }
    }
}

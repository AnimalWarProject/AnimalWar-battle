package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
public class AttackerPoisonImpl implements AttackerAttackTypeSkill {

    @Override
    public void attackTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double poisonProbability = 0.7;
        Random random = new Random();
        // 1. 포이즌 스킬 발동 설정
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;
        
        // 1-1. 포이즌 스킬 발동
        int poisonDamage = (int) (1.05 * defender.getMaxLife());
        
        // 2. 포이즌 스킬 사용 (확률 발동)
        if (random.nextDouble() < poisonProbability){
        remainingHealth = defenderLife - poisonDamage;
        defender.setLife(remainingHealth);
        } else {
            System.out.println("Poison skill failed");
        }
        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공격 성공");
        }
    }
}
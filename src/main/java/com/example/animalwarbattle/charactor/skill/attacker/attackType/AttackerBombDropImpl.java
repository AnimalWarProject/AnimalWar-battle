package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

/*  폭탄 투하: 상대방 현재 체력의 10%에 해당하는 데미지를 입힙니다.  */
public class AttackerBombDropImpl implements AttackerAttackTypeSkill {

    @Override
    public void attackTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double bombDropProbability = 0.65;
        Random random = new Random();
        // 1. 폭탄 투하 스킬 발동 설정
        // 수비자 체력 설정
        int defenderLife = defender.getLife();

        
        // 1-1. 폭탄 투하 발동


        // 2. 스킬 사용(확률 발동)
        if (random.nextDouble() < bombDropProbability){
            int  remainingHealth = (int) (0.9 * defender.getLife());

            defender.setLife(remainingHealth);


        } else {
            System.out.println("BombDrop skill failed");
        }

        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공격 성공");
        }
    }
}

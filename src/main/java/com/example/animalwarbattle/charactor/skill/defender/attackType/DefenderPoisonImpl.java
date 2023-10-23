package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

/*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
public class DefenderPoisonImpl implements DefenderPoisonSkill {
    @Override
    public Integer poison(Character attacker, Character defender) {
        // 1. 포이즌 스킬 발동 설정
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;
        
        // 1-1. 포이즌 스킬 발동
        int poisonDamage = (int) (1.05 * attacker.getMaxLife());
        
        // 2. 포이즌 스킬 사용
        remainingHealth = attackerLife - poisonDamage;
        attacker.setLife(remainingHealth);
        
        // 3. 공격자 체력 0이하 승리
        if (attackerLife <=0) {
            System.out.println("수비자 승리 == 수비 성공");
        }
        return remainingHealth;
    }
}
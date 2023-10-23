package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

public class DefenderBombDropImpl implements DefenderBombDropSkill {
    @Override
    public Integer bombDrop(Character attacker, Character defender) {
        // 1. 폭탄 투하 스킬 발동 및 상성 체크
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;
        
        // 1-1. 폭탄 투하 발동
        int bombDropDamage = (int) (1.1 * attacker.getLife());

        // 2. 스킬 사용
        remainingHealth = attackerLife - bombDropDamage;
        attacker.setLife(remainingHealth);
        
        // 3. 공격자 체력 0이하 승리
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 == 수비 성공");
        }
        return remainingHealth;
    }
}

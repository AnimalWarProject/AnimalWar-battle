package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import lombok.AllArgsConstructor;

/*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
@AllArgsConstructor
public class AttackerPoisonImpl implements AttackerPoisonSkill {

    @Override
    public Integer poison(Character attacker, Character defender) {
        // 1. 포이즌 스킬 발동 설정
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;
        
        // 1-1. 포이즌 스킬 발동
        int poisonDamage = (int) (1.05 * defender.getMaxLife());
        
        // 2. 포이즌 스킬 사용
        remainingHealth = defenderLife - poisonDamage;
        defender.setLife(remainingHealth);
        
        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공격 성공");
        }
        return remainingHealth;
    }
}
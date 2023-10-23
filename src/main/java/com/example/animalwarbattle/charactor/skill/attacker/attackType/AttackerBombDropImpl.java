package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  폭탄 투하: 상대방 현재 체력의 10%에 해당하는 데미지를 입힙니다.  */
@AllArgsConstructor
public class AttackerBombDropImpl implements AttackerBombDropSkill {

    @Override
    public Integer bombDrop(Character attacker, Character defender) {
        // 1. 폭탄 투하 스킬 발동 설정
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;
        
        // 1-1. 폭탄 투하 발동
        int bombDropDamage = (int) (1.1 * defender.getLife());

        // 2. 스킬 사용
        remainingHealth = defenderLife - bombDropDamage;
        defender.setLife(remainingHealth);

        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공격 성공");
        }
        return remainingHealth;
    }
}

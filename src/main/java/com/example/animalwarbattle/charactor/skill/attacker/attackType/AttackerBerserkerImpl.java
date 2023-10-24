package com.example.animalwarbattle.charactor.skill.attacker.attackType;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

/*  버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
@AllArgsConstructor
@NoArgsConstructor
public class AttackerBerserkerImpl implements AttackerAttackTypeSkill {
    private CompatibilityChecker compatibilityChecker = new CompatibilityChecker();


    @Override
    public void attackTypeAttackerExecute(Character attacker, Character defender) {
        
        // 0. 스킬 확률
        double berserkerProbability = 0.7;
        Random random = new Random();
        // 1. 버서커 스킬 발동 조건 및 상성 체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;

        // 1-1. 버서커 스킬 발동 조건 및 공격력 설정
        int berserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            berserkerDamage *= 2;
            // 공격 횟수 찾기
        }
        // 상성체크
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            berserkerDamage = attacker.getAttackerPower();
        }

        // 2. 스킬 사용(확률 발동)
        if (random.nextDouble() < berserkerProbability){
        remainingHealth = defenderLife - berserkerDamage;
        defender.setLife(remainingHealth);
        } else {
            System.out.println("Berserker skill failed");
        }

        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공격 성공");
        }

    }
}



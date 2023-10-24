package com.example.animalwarbattle.charactor.skill.defender.attackType;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
public class DefenderBerserkerImpl implements DefenderAttackTypeSkill {
    private final CompatibilityChecker compatibilityChecker = new CompatibilityChecker();


    @Override
    public void defendTypeAttackerExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double berserkerProbability = 0.7;
        Random random = new Random();
        // 1. 버서커 스킬 발동 조건 및 상성체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;

        // 1-1. 버서커 스킬 발동 조건 및 수비력 설정
        int berserkerDamage = defender.getDefensePower();
        if (defender.getMaxLife() / 5 >= defender.getLife()) {
            berserkerDamage *= 2;
        }
        // 상성체크
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(defender);
            berserkerDamage = defender.getDefensePower();
        }
        
        // 2. 스킬 사용 (확률 발동)
        if (random.nextDouble() < berserkerProbability){
        remainingHealth = attackerLife - berserkerDamage;
        attacker.setLife(remainingHealth);
        } else {
            System.out.println("Berserker skill failed");
        }

        // 3. 공격자 체력 0이하 승리
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 == 방어 성공");
        }
    }
}



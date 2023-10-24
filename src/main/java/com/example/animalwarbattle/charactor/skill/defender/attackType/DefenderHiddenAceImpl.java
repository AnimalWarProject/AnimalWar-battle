package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.utill.CompatibilityChecker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class DefenderHiddenAceImpl implements DefenderAttackTypeSkill {
    private final CompatibilityChecker compatibilityChecker;
    
    @Override
    public void attackTypeDefenderExecute(Character attacker, Character defender) {
        // 0. 스킬 확률
        double hiddenAceProbability = 0.7;
        Random random = new Random();

        // 1. 히든 에이스 스킬 발동 조건 및 상성체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 공격자 체력 설정
        int attackerLife = attacker.getLife();
        int remainingHealth;

        // 1-1. 히든 에이스 스킬 수비력 설정
        int hiddenAceDamage = defender.getDefensePower();
        if (defender.getLife() < attacker.getLife()) {
            hiddenAceDamage *= 5;
        }

        //상성체크
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(defender);
            hiddenAceDamage = defender.getDefensePower();
        }

        // 2. 스킬 사용(확률 발동)
        if (random.nextDouble() < hiddenAceProbability) {
        remainingHealth = attackerLife - hiddenAceDamage;
        attacker.setLife(remainingHealth);
        } else {
            System.out.println("Execution skill failed");
        }

        // 3. 공격자 채력 0이하 승리
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 == 수비 성공");
        }
    }
}

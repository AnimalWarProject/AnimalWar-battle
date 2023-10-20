package com.example.animalwarbattle.charactor.basicAttack.defender;

import com.example.animalwarbattle.charactor.basicAttack.attacker.BasicAttack;
import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicDefendImpl implements BasicDefend {
    private final CompatibilityChecker compatibilityChecker;

    // 기본 공격과 수비자 상성우위이면 10% 상승
    @Override
    public Integer defendPlainHit(Character attacker, Character defender) {
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);

        // 기본 공격 수치
        int plainHit = defender.getDefensePower();
        int increaseHit = defender.getDefensePower();
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(defender);
            increaseHit = defender.getDefensePower();
        } else {
            plainHit = defender.getDefensePower();
        }
        int attackerLife = attacker.getLife();
        int remainHealth;

        if (hasCompatibility) {
            remainHealth = attackerLife - increaseHit;
        } else {
            remainHealth = attackerLife - plainHit;
        }
        attacker.setLife(remainHealth);
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 === 전투 종료");
        }
        return remainHealth;
    }
}

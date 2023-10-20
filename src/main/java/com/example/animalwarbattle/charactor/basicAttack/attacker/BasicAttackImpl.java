package com.example.animalwarbattle.charactor.basicAttack.attacker;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicAttackImpl implements BasicAttack{
    private final CompatibilityChecker compatibilityChecker;

    // 기본 공격과 공격자가 상성우위이면 10% 상승
    @Override
    public Integer attackPlainHit(Character attacker, Character defender) {
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 기본공격 수치
        int plainHit = attacker.getAttackerPower();
        int increaseHit = attacker.getAttackerPower();
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            increaseHit = attacker.getAttackerPower();
        } else {
            plainHit = attacker.getAttackerPower();
        }
        // 수비자 체력
        int defenderLife = defender.getLife();

        // 수비자 남은 체력
        int remainingHealth;
        
        // 상성이 있는 경우, 상승한 공격력으로 수비자를 공격
        // 상성이 없는 경우, 기본 공격력으로 수비자를 공격
        if (hasCompatibility) {
            remainingHealth = defenderLife - increaseHit;
        } else {
            remainingHealth = defenderLife - plainHit;
        }
        defender.setLife(remainingHealth);

        if (defenderLife <= 0) {
            System.out.println("공격자 승리 === 전투 종료");
        }
        return remainingHealth;
    }
}

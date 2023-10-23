package com.example.animalwarbattle.charactor.basicAttack.attacker;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicAttackImpl implements BasicAttack{
    private final CompatibilityChecker compatibilityChecker;

    @Override
    public Integer attackPlainHit(Character attacker, Character defender) {

        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 기본 공격과 상성 우위일 때 값 구별
        int defenderLife = defender.getLife();
        // 수비자 남은 체력 설정
        int remainingHealth;
        // 상성이 있는 경우, 상승한 공격력으로 수비자를 공격
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            // 상성우위일 때 값
            int increaseHit = attacker.getAttackerPower();
            // 수비자 남은체력(상승된 공격력으로 받았을 때)
            remainingHealth = defenderLife - increaseHit;
            // 상성이 없는 경우, 기본 공격력으로 수비자를 공격
        } else {
            // 기본공격 값
            int plainHit = attacker.getAttackerPower();
            // 수비자 남은체력(기본 공격력으로 받았을 때)
            remainingHealth = defenderLife - plainHit;
        }
            // 수비자 체력 set
            defender.setLife(remainingHealth);

        // 수비자 체력 0 이하이면, 종료
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 === 공격 성공");
        }
        return remainingHealth;
    }
}

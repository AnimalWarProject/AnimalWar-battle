package com.example.animalwarbattle.charactor.basicAttack.defender;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.utill.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicDefendImpl implements BasicDefend {
    private final CompatibilityChecker compatibilityChecker;

    // 기본 공격과 수비자 상성우위이면 10% 상승
    @Override
    public void defendPlainHit(Character attacker, Character defender) {
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 기본 공격과 상성 우윌일 때 값 구별
        int attackerLife = attacker.getLife();
        // 공격자 남은 체력 설정
        int remainingHealth;
        // 상성이 있는 경우 , 상승한 수비력으로 공격자를 공격
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(defender);
            // 상승 우위일 때 값
            int increaseHit = defender.getDefensePower();
            // 공격자 남은 체력(상승된 수비력으로 받았을 때)
            remainingHealth = attackerLife - increaseHit;
        } else {
            // 기본 공격 값
            int plainHit = defender.getDefensePower();
            // 공격자 남은 체력(기본 공격으로 받았을 때)
            remainingHealth = attackerLife - plainHit;
        }
            // 공격자 체력 set
            attacker.setLife(remainingHealth);

        // 공격자 체력 0 이하이면, 종료
        if (attackerLife <= 0) {
            System.out.println("수비자 승리 === 방어 성공");
        }
    }
}

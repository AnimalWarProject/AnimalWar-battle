package com.example.animalwarbattle.charactor.skill.attacker.attackType;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
@AllArgsConstructor
public class AttackerBerserkerImpl implements AttackerBerserkerSkill {
    private final CompatibilityChecker compatibilityChecker;

    @Override
    public Integer berserker(Character attacker, Character defender) {
        // 1. 버서커 스킬 발동 조건 및 상성 체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 1-1. 버서커 스킬 발동 조건 및 공격력 설정
        Integer berserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            berserkerDamage = berserkerDamage * 2;
        }

        Integer increaseBerserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            increaseBerserkerDamage = increaseBerserkerDamage * 2;
        }

        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            increaseBerserkerDamage = attacker.getAttackerPower();
        } else {
            berserkerDamage = attacker.getAttackerPower();
        }
        int defenderLife = defender.getLife();

        int remainingHealth;

        if (hasCompatibility) {
            remainingHealth = defenderLife - increaseBerserkerDamage;
        } else {
            remainingHealth = defenderLife - berserkerDamage;
        }
        defender.setLife(remainingHealth);

        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공경 성공");
        }
        return remainingHealth;
    }
}



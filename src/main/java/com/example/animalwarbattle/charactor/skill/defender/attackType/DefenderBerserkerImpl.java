package com.example.animalwarbattle.charactor.skill.defender.attackType;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.skill.attacker.attackType.AttackerBerserkerSkill;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefenderBerserkerImpl implements AttackerBerserkerSkill {
    private final CompatibilityChecker compatibilityChecker;


    @Override
    public Integer berserker(Character attacker, Character defender) {
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);

        Integer berserkerDamage = defender.getDefensePower();
        if (defender.getMaxLife() / 5 >= defender.getLife()) {
            berserkerDamage = berserkerDamage * 2;
        }

        Integer increaseBerserkerDamage = defender.getDefensePower();
        if (defender.getMaxLife() / 5 >= defender.getLife()) {
            increaseBerserkerDamage = increaseBerserkerDamage * 2;
        }

        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(defender);
            increaseBerserkerDamage = defender.getDefensePower();
        } else {
            berserkerDamage = defender.getDefensePower();
        }
        int attackerLife = attacker.getLife();
        int remainingHealth;

        if (hasCompatibility) {
            remainingHealth = attackerLife - increaseBerserkerDamage;
        } else {
            remainingHealth = attackerLife - berserkerDamage;
        }
        attacker.setLife(remainingHealth);

        if (attackerLife <= 0) {
            System.out.println("수비자 승리 == 방어 성공");
        }
        return remainingHealth;
    }
}



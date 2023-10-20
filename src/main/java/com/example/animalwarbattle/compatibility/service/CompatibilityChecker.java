package com.example.animalwarbattle.compatibility.service;

import com.example.animalwarbattle.compatibility.domain.entity.CompatibilityEnum;
import com.example.animalwarbattle.domain.entity.Character;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityChecker implements CompatibilityCheckInterface {

    // 공격자와 수비자의 상성을 확인하는 메서드
    @Override
    public boolean check(Character attacker, Character defender) {
        // 공격자 상성, 수비자 상성 설정
        CompatibilityEnum attackerCompatibility = attacker.getCompatibility();
        CompatibilityEnum defenderCompatibility = defender.getCompatibility();

        // 상성이면 true, 비상성이면 false
        boolean isCompatible = false;

        // 각 상성 조합에 따라 상성 확인 후, 전투력을 증가시키는 메서드 호출
        //개 - 새 상성관계에 따른 전투력 부여
        if (attackerCompatibility == CompatibilityEnum.DOG) {
            if (defenderCompatibility == CompatibilityEnum.BIRD) {
                isCompatible = true;
                increaseCombatPower(attacker, true);
            } else {
                isCompatible = false;
            }
        } else if (attackerCompatibility == CompatibilityEnum.BIRD) {
            if (defenderCompatibility == CompatibilityEnum.DOG) {
                isCompatible = true;
                increaseCombatPower(defender, true);
            } else {
                isCompatible = false;
            }

        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.BIRD) {
            if (defenderCompatibility == CompatibilityEnum.CAT) {
                isCompatible = true;
                increaseCombatPower(attacker, true);
            } else {
                isCompatible = false;
            }
        } else if (defenderCompatibility == CompatibilityEnum.BIRD) {
            if (attackerCompatibility == CompatibilityEnum.CAT) {
                isCompatible = true;
                increaseCombatPower(defender, true);
            } else {
                isCompatible = false;
            }

        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT){
            if (defenderCompatibility == CompatibilityEnum.GLIRES) {
                isCompatible = true;
                increaseCombatPower(attacker, true);
            } else {
                isCompatible = false;
            }
        } else if (defenderCompatibility == CompatibilityEnum.CAT) {
            if (attackerCompatibility == CompatibilityEnum.GLIRES) {
                isCompatible = true;
                increaseCombatPower(defender, true);
            } else {
                isCompatible = false;
            }
            
        // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES) {
            if (defenderCompatibility == CompatibilityEnum.FISH) {
                isCompatible = true;
                increaseCombatPower(attacker, true);
            } else {
                isCompatible = false;
            }
        } else if (defenderCompatibility == CompatibilityEnum.GLIRES) {
            if (attackerCompatibility == CompatibilityEnum.FISH) {
                isCompatible = true;
                increaseCombatPower(defender, true);
            } else {
                isCompatible = false;
            }

        // 어류 - 개 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.FISH) {
            if (defenderCompatibility == CompatibilityEnum.DOG) {
                isCompatible = true;
                increaseCombatPower(attacker, true);
            } else {
                isCompatible = false;
            }
        } else if (defenderCompatibility == CompatibilityEnum.FISH) {
            if (attackerCompatibility == CompatibilityEnum.DOG) {
                isCompatible = true;
                increaseCombatPower(defender, true);
            } else {
                isCompatible = false;
            }
        }
        return isCompatible;
    }
    // // 해당 종족의 전투력 10% 증가시키는 메서드
    private void increaseCombatPower(Character character, boolean isCompatibility){
        int compatibilityPower = character.getCombatPower(isCompatibility);
        double increasePower = compatibilityPower * 1.1;
        character.setCombatPower(isCompatibility, (int) increasePower);
        character.setCombatPower(!isCompatibility, (int) increasePower);
    }

}

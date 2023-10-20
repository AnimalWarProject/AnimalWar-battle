package com.example.animalwarbattle.compatibility.service;

import com.example.animalwarbattle.compatibility.domain.entity.CompatibilityEnum;
import com.example.animalwarbattle.charactor.domain.entity.Character;
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


        // 각 상성 조합에 따라 상성 확인 후, 전투력을 증가시키는 메서드 호출
        //개 - 새 상성관계에 따른 전투력 부여
        if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseCombatPower(attacker, true);
            return true;
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseCombatPower(defender, true);
            return true;

        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.CAT) {
                increaseCombatPower(attacker, true);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.BIRD
                && attackerCompatibility == CompatibilityEnum.CAT) {
                increaseCombatPower(defender, true);
                return true;

        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
                increaseCombatPower(attacker, true);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.CAT
                && attackerCompatibility == CompatibilityEnum.GLIRES) {
                increaseCombatPower(defender, true);
                return true;
            
        // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.FISH) {
                increaseCombatPower(attacker, true);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.GLIRES
                && attackerCompatibility == CompatibilityEnum.FISH) {
                increaseCombatPower(defender, true);
                return true;

        // 어류 - 개 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.DOG) {
                increaseCombatPower(attacker, true);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.FISH
                && attackerCompatibility == CompatibilityEnum.DOG) {
                increaseCombatPower(defender, true);
                return true; }

        return false;
    }
    // // 해당 종족의 전투력 10% 증가시키는 메서드
    private void increaseCombatPower(Character character, boolean isCompatibility){
        int compatibilityPower = character.getCombatPower(isCompatibility);
        double increasePower = compatibilityPower * 1.1;
        character.setCombatPower(isCompatibility, (int) increasePower);
        character.setCombatPower(!isCompatibility, (int) increasePower);
    }
}

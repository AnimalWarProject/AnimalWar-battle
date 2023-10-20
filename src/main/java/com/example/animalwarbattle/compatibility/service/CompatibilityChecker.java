package com.example.animalwarbattle.compatibility.service;

import com.example.animalwarbattle.compatibility.domain.entity.CompatibilityEnum;
import com.example.animalwarbattle.domain.entity.Character;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityChecker implements CompatibilityCheckInterface {

    @Override
    public boolean check(Character attacker, Character defender) {
        // 공격자 상성, 수비자 상성 설정
        CompatibilityEnum attackerCompatibility = attacker.getCompatibility();
        CompatibilityEnum defenderCompatibility = defender.getCompatibility();

        boolean isCompatible = false;

        // 상성이면 true, 비상성이면 false
//        return (attackerCompatibility == CompatibilityEnum.DOG && defenderCompatibility == CompatibilityEnum.BIRD) ||
//                (attackerCompatibility == CompatibilityEnum.BIRD && defenderCompatibility == CompatibilityEnum.CAT) ||
//                (attackerCompatibility == CompatibilityEnum.CAT && defenderCompatibility == CompatibilityEnum.MOUSE) ||
//                (attackerCompatibility == CompatibilityEnum.MOUSE && defenderCompatibility == CompatibilityEnum.FISH);
//
        if (attackerCompatibility == CompatibilityEnum.DOG && defenderCompatibility == CompatibilityEnum.BIRD){
            isCompatible = true;
            increaseCombatPower(attacker);
            increaseCombatPower(defender);
        } else if (attackerCompatibility == CompatibilityEnum.BIRD && defenderCompatibility == CompatibilityEnum.CAT){
            isCompatible = true;
            increaseCombatPower(attacker);
            increaseCombatPower(defender);
        } else if (attackerCompatibility == CompatibilityEnum.CAT && defenderCompatibility == CompatibilityEnum.GLIRES){
            isCompatible =true;
            increaseCombatPower(attacker);
            increaseCombatPower(defender);
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES && defenderCompatibility == CompatibilityEnum.FISH) {
            isCompatible =true;
            increaseCombatPower(attacker);
            increaseCombatPower(defender);
        } else if (attackerCompatibility == CompatibilityEnum.FISH && defenderCompatibility == CompatibilityEnum.DOG) {
            isCompatible =true;
            increaseCombatPower(attacker);
            increaseCombatPower(defender);
        }
        return isCompatible;
    }
    // 해당 종족의 전투력 10% 증가
    private void increaseCombatPower(Character character){
        int compatibilityPower = character.getCombatPower();
        double increasePower = compatibilityPower * 1.1;
        character.setCompatibility();
    }

}

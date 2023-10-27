package com.example.animalwarbattleservice.compatibility.utill;


import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompatibilityChecker{

    // 공격자와 수비자의 상성을 확인하는 메서드
    public boolean check(CharacterDto attacker, CharacterDto defender) {
        // 공격자 상성, 수비자 상성 설정
        CompatibilityEnum attackerCompatibility = attacker.getCompatibility();
        CompatibilityEnum defenderCompatibility = defender.getCompatibility();

        // 각 상성 조합에 따라 상성 확인 후, 전투력을 증가시키는 메서드 호출
        //개 - 새 상성관계에 따른 전투력 부여
        if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseAttackerCombatPower(attacker);
            return true;
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseDefenderCombatPower(defender);
            return true;

        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.CAT) {
            increaseAttackerCombatPower(attacker);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.BIRD
                && attackerCompatibility == CompatibilityEnum.CAT) {
            increaseDefenderCombatPower(defender);
                return true;

        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
            increaseAttackerCombatPower(attacker);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.CAT
                && attackerCompatibility == CompatibilityEnum.GLIRES) {
            increaseDefenderCombatPower(defender);
                return true;
            
        // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.FISH) {
            increaseAttackerCombatPower(attacker);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.GLIRES
                && attackerCompatibility == CompatibilityEnum.FISH) {
            increaseDefenderCombatPower(defender);
                return true;

        // 어류 - 개 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseAttackerCombatPower(attacker);
                return true;
        } else if (defenderCompatibility == CompatibilityEnum.FISH
                && attackerCompatibility == CompatibilityEnum.DOG) {
            increaseDefenderCombatPower(defender);
                return true; }

        return false;
    }
    // 공격자의 전투력을 10% 증가시키는 메서드
    public void increaseAttackerCombatPower(CharacterDto isAttacker) {
        int attackerPower = isAttacker.getAttackerPower();
        double increasedPower = attackerPower * 1.1;
        isAttacker.changeAtkp((int) increasedPower);
    }

    // 수비자의 전투력을 10% 증가시키는 메서드
    public void increaseDefenderCombatPower(CharacterDto isDefender) {
        int defenderPower = isDefender.getDefensePower();
        double increasedPower = defenderPower * 1.1;
        isDefender.changeDef((int) increasedPower);
    }
}
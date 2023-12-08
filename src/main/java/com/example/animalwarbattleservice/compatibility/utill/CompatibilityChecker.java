package com.example.animalwarbattleservice.compatibility.utill;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompatibilityChecker{
    public String check(CharacterDto attacker, CharacterDto defender) {
        CompatibilityEnum attackerCompatibility = attacker.getCompatibilityEnum();
        CompatibilityEnum defenderCompatibility = defender.getCompatibilityEnum();


        if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";

        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseAttackerCombatPower(defender);
            return "Defender";

        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.CAT) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";

        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseAttackerCombatPower(defender);
            return "Defender";

        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";

        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.CAT) {
            increaseAttackerCombatPower(defender);
            return "Defender";

        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.FISH) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";

        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
            increaseAttackerCombatPower(defender);
            return "Defender";

        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";

        } else if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.FISH) {
            increaseAttackerCombatPower(defender);
            System.out.println(defender.getDefensePower());
            return "Defender";
        }
        return "";
    }

    // 상성에 따라 공격자의 전투력 10% 상승
    public void increaseAttackerCombatPower(CharacterDto isAttacker) {
        int battlePower = isAttacker.getAttackPower();
        int defenderPower = isAttacker.getDefensePower();
        double increasedBattlePower = battlePower * 1.1;
        double increasedDefendPower = defenderPower * 1.1;
        isAttacker.changeBattlePower((int) increasedBattlePower);
        isAttacker.changeDefenderPower((int) increasedDefendPower);
    }

    // 수비자의 전투력을 10% 증가시키는 메서드
    public void increaseDefenderCombatPower(CharacterDto isDefender) {
        int battlePower = isDefender.getAttackPower();
        int defenderPower = isDefender.getDefensePower();
        double increasedBattlePower = battlePower * 1.1;
        double increasedDefendPower = defenderPower * 1.1;
        isDefender.changeBattlePower((int) increasedBattlePower);
        isDefender.changeDefenderPower((int) increasedDefendPower);
    }
}
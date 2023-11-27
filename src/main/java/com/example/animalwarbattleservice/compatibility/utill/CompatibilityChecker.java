package com.example.animalwarbattleservice.compatibility.utill;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompatibilityChecker{

    // 공격자와 수비자의 상성을 확인하는 메서드
    public String check(CharacterDto attacker, CharacterDto defender) {
        // 공격자 상성, 수비자 상성 설정
        CompatibilityEnum attackerCompatibility = attacker.getCompatibilityEnum();
        CompatibilityEnum defenderCompatibility = defender.getCompatibilityEnum();

        // 각 상성 조합에 따라 상성 확인 후, 전투력을 증가시키는 메서드 호출
        //개 - 새 상성관계에 따른 전투력 부여 개 우승
        if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";
        // 새 - 개 상성관계에 따른 전투력 부여  개 우승
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseAttackerCombatPower(defender);
            return "Defender";
        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.CAT) {
            increaseAttackerCombatPower(attacker);

            return "Attacker";
        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            increaseAttackerCombatPower(defender);

            return "Defender";
        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
            increaseAttackerCombatPower(attacker);
            return "Attacker";
        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.CAT) {
            increaseAttackerCombatPower(defender);

            return "Defender";

        // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.FISH) {
            increaseAttackerCombatPower(attacker);

            return "Attacker";
            // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
            increaseAttackerCombatPower(defender);

            return "Defender";

        // 어류 - 개 상성에 따른 전투력 부여 어류 승
        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.DOG) {
            increaseAttackerCombatPower(attacker);

            System.out.println("111");
            return "Attacker";
        // 어류 - 개 상성에 따른 전투력 부여  어류승
        } else if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.FISH) {
            System.out.println("222");
            increaseAttackerCombatPower(defender);
            System.out.println(defender.getDefensePower());

            return "Defender";
        }
        return "";
    }
    // 공격자의 전투력을 10% 증가시키는 메서드
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
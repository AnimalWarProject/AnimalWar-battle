package com.example.animalwarbattleservice.compatibility.utill;


import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.AttackerCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.DefenderCharacterDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Component
public class CompatibilityChecker{

    // 공격자와 수비자의 상성을 확인하는 메서드
    public boolean check(CharacterDto attacker, CharacterDto defender) {
        // 공격자 상성, 수비자 상성 설정
        CompatibilityEnum attackerCompatibility = attacker.getCompatibilityEnum();
        CompatibilityEnum defenderCompatibility = defender.getCompatibilityEnum();

        // 각 상성 조합에 따라 상성 확인 후, 전투력을 증가시키는 메서드 호출
        //개 - 새 상성관계에 따른 전투력 부여
        System.out.println("공격자 종족 =" + attackerCompatibility);
        System.out.println("수비자 종족 =" + defenderCompatibility);

        if (attackerCompatibility == CompatibilityEnum.DOG
                && defenderCompatibility == CompatibilityEnum.BIRD) {
            return true;
        // 새 - 고양이 상성관계에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.BIRD
                && defenderCompatibility == CompatibilityEnum.CAT) {
                return true;
        // 고양이 - 설치류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.CAT
                && defenderCompatibility == CompatibilityEnum.GLIRES) {
                return true;
        // 설치류 - 어류 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.GLIRES
                && defenderCompatibility == CompatibilityEnum.FISH) {
                return true;
        // 어류 - 개 상성에 따른 전투력 부여
        } else if (attackerCompatibility == CompatibilityEnum.FISH
                && defenderCompatibility == CompatibilityEnum.DOG) {
            return true;
        }
        return false;
    }
    // 공격자의 전투력을 10% 증가시키는 메서드
    public void increaseAttackerCombatPower(AttackerCharacterDto isAttacker) {
        int attackerPower = isAttacker.getAttackerPower();
        double increasedPower = attackerPower * 1.1;
        isAttacker.changeAtkp((int) increasedPower);
    }

    // 수비자의 전투력을 10% 증가시키는 메서드
    public void increaseDefenderCombatPower(DefenderCharacterDto isDefender) {
        int defenderPower = isDefender.getDefensePower();
        double increasedPower = defenderPower * 1.1;
        isDefender.changeDef((int) increasedPower);
    }
}
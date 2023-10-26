package com.example.animalwarbattleservice.user.domain.charactor.service;

import com.example.animalwarbattleservice.compatibility.utill.CompatibilityChecker;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderUtilityTypeSkill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CombatService extends CharacterDto {

    // 기본 공격
    private AttackerBasicAttack attackerBasicAttack;
    private DefenderBasicAttack defenderBasicAttack;

    // 공격형 스킬
    private AttackerAttackTypeSkill attackerAttackTypeSkill;
    private DefenderAttackTypeSkill defenderAttackTypeSkill;

    // 수비형 스킬
    private AttackerDefensiveTypeSkill attackerDefensiveTypeSkill;
    private DefenderDefensiveTypeSkill defenderDefensiveTypeSkill;

    // 유틸형 스킬
    private AttackerUtilityTypeSkill attackerUtilityTypeSkill;
    private DefenderUtilityTypeSkill defenderUtilityTypeSkill;

    // 상성체크
    private CompatibilityChecker compatibilityChecker;



    public void checkCompatibility(CharacterDto character) {
        if (compatibilityChecker.check(character, character == attacker ? defender : attacker)) {
            compatibilityChecker.increaseAttackerCombatPower(character);
        }
    }




    // 공격자 처형 스킬
    public void useAttackerExecution(CharacterDto attacker, CharacterDto defender) {
        // 스킬을 사용하는 로직
        attackerBasicAttack.attackPlainHit(attacker, defender);

        // 스킬 사용 후 피가 깍였을 때, 즉결처형 해야하는지 확인하는 로직이다
        if (attacker.getExecutionSkillCount() > 0) {
            if (defender.getLife() <= defender.getMaxLife() / 10) {
                defender.changeLife(0);
            }
            attacker.decrementExecutionCount();
        }
    }

    // 수비자 처형 스킬
    public void useDefenderExecution(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);

        if (defender.getExecutionSkillCount() > 0) {
            if (attacker.getLife() <= attacker.getLife() / 10) {
                attacker.changeLife(0);
            }
            defender.decrementExecutionCount();
        }
    }

    // 공격자 철통 방어
    public void useAttackerIroncladDefense(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);
        if (defender.getIroncladDefenseSkillCount() > 0) {
            defender.blockBasicAttack();
            defender.decrementIroncladDefenseCount();
        }
    }

    // 수비자 철통 방어
    public void useDefenderIroncladDefense(CharacterDto attacker, CharacterDto defender) {
        attackerBasicAttack.attackPlainHit(attacker, defender);
        if (attacker.getIroncladDefenseSkillCount() > 0) {
            attacker.blockBasicAttack();
            attacker.decrementIroncladDefenseCount();
        }
    }

    // 공격자 럭키 7
    public void useAttackerLuckySeven(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);
        if (defender.getLuckySevenSkillCount() > 0) {
            defender.blockBasicAttack();
            defender.decrementLuckySevenCount();
        }
    }

    // 수비자 럭키 7
    public void useDefenderLuckySeven(CharacterDto attacker, CharacterDto defender) {
        attackerBasicAttack.attackPlainHit(attacker, defender);
        if (attacker.getLuckySevenSkillCount() > 0) {
            attacker.blockBasicAttack();
            attacker.decrementLuckySevenCount();
        }
    }


    // attacker vs defender
    public void oneBattle(CharacterDto attacker, CharacterDto defender) {
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
        }

        while (attacker.getLife() > 0 && defender.getLife() > 0) {

        }
    }
}



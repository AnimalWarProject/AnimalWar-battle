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
    private CharacterDto attacker;
    private CharacterDto defender;


    // 기본 공격(공격자, 수비자)
    public void useBasicAttack(CharacterDto attacker, CharacterDto defender){
        attackerBasicAttack.attackPlainHit(attacker, defender);
    }
    public void useBasicDefend(CharacterDto attacker, CharacterDto defender){
        defenderBasicAttack.defendPlainHit(attacker, defender);
    }

    // 공격형 스킬(공격자, 수비자)
    public void useAttackerAttackType(CharacterDto attacker, CharacterDto defender){
        attackerAttackTypeSkill.attackTypeAttackerBerserker(attacker, defender);
        attackerAttackTypeSkill.attackTypeAttackerBombDrop(attacker, defender);
        attackerAttackTypeSkill.attackTypeAttackerExecution(attacker, defender);
        attackerAttackTypeSkill.attackTypeAttackerHiddenAce(attacker, defender);
        attackerAttackTypeSkill.attackTypeAttackerPoison(attacker, defender);
        attackerAttackTypeSkill.attackTypeAttackerSpeedRun(attacker, defender);
    }
    public void useDefenderAttackType(CharacterDto attacker, CharacterDto defender){
        defenderAttackTypeSkill.attackTypeDefenderBerserker(attacker, defender);
        defenderAttackTypeSkill.attackTypeDefenderBombDrop(attacker, defender);
        defenderAttackTypeSkill.attackTypeDefenderExecution(attacker, defender);
        defenderAttackTypeSkill.attackTypeDefenderHiddenAce(attacker, defender);
        defenderAttackTypeSkill.attackTypeDefenderPoison(attacker, defender);
        defenderAttackTypeSkill.attackTypeDefenderSpeedRun(attacker, defender);
    }

    // 수비형 스킬(공격자, 수비자)
    public void useAttackerDefensiveType(CharacterDto attacker, CharacterDto defender){
        attackerDefensiveTypeSkill.defensiveTypeAttackerEmergencyFood(attacker, defender);
        attackerDefensiveTypeSkill.defensiveTypeAttackerHeal(attacker, defender);
        attackerDefensiveTypeSkill.defensiveTypeAttackerIroncladDefense(attacker, defender);
        attackerDefensiveTypeSkill.defensiveTypeAttackerLuckySeven(attacker, defender);
//        attackerDefensiveTypeSkill.defensiveTypeAttackerRustedSword(attacker, defender);
//        attackerDefensiveTypeSkill.defensiveTypeAttackerBandage(attacker, defender);
    }
    public void useDefenderDefensiveType(CharacterDto attacker, CharacterDto defender){
        defenderDefensiveTypeSkill.defensiveTypeDefenderEmergencyFood(attacker, defender);
        defenderDefensiveTypeSkill.defensiveTypeDefenderHeal(attacker, defender);
        defenderDefensiveTypeSkill.defensiveTypeDefenderIroncladDefense(attacker, defender);
        defenderDefensiveTypeSkill.defensiveTypeDefenderLuckySeven(attacker, defender);
//        defenderDefensiveTypeSkill.defensiveTypeDefenderRustedSword(attacker, defender);
//        defenderDefensiveTypeSkill.defensiveTypeDefenderBandage(attacker, defender);
    }

    // 유팅형 스킬(공격자, 수비자)
    public void useAttackerUtilityType(CharacterDto attacker, CharacterDto defender){
        attackerUtilityTypeSkill.utilityTypeAttackerBrokenShield(attacker, defender);
        attackerUtilityTypeSkill.utilityTypeAttackerBrokenSpear(attacker, defender);
        attackerUtilityTypeSkill.utilityTypeAttackerDoItAgain(attacker, defender);
        attackerUtilityTypeSkill.utilityTypeAttackerOffenseDefenseShift(attacker, defender);
        attackerUtilityTypeSkill.utilityTypeAttackerStrongAndWeak(attacker, defender);
        attackerUtilityTypeSkill.utilityTypeAttackerSwap(attacker, defender);
    }
    public void useDefenderUtilityType(CharacterDto attacker, CharacterDto defender){
        defenderUtilityTypeSkill.utilityTypeDefenderBrokenShield(attacker, defender);
        defenderUtilityTypeSkill.utilityTypeDefenderBrokenSpear(attacker, defender);
        defenderUtilityTypeSkill.utilityTypeDefenderDoItAgain(attacker, defender);
        defenderUtilityTypeSkill.utilityTypeDefenderOffenseDefenseShift(attacker, defender);
        defenderUtilityTypeSkill.utilityTypeDefenderStrongAndWeak(attacker, defender);
        defenderUtilityTypeSkill.utilityTypeDefenderSwap(attacker, defender);
    }


    // 처형 스킬(공격자, 수비자)
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
    public void useDefenderExecution(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);

        if (defender.getExecutionSkillCount() > 0) {
            if (attacker.getLife() <= attacker.getLife() / 10) {
                attacker.changeLife(0);
            }
            defender.decrementExecutionCount();
        }
    }

    // 철통 방어(공격자 , 수비자)
    public void useAttackerIroncladDefense(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);
        if (defender.getIroncladDefenseSkillCount() > 0) {
            defender.blockBasicAttack();
            defender.decrementIroncladDefenseCount();
        }
    }
    public void useDefenderIroncladDefense(CharacterDto attacker, CharacterDto defender) {
        attackerBasicAttack.attackPlainHit(attacker, defender);
        if (attacker.getIroncladDefenseSkillCount() > 0) {
            attacker.blockBasicAttack();
            attacker.decrementIroncladDefenseCount();
        }
    }

    // 럭키 7 스킬(공격자, 수비자)
    public void useAttackerLuckySeven(CharacterDto attacker, CharacterDto defender) {
        defenderBasicAttack.defendPlainHit(attacker, defender);
        if (defender.getLuckySevenSkillCount() > 0) {
            defender.blockBasicAttack();
            defender.decrementLuckySevenCount();
        }
    }
    public void useDefenderLuckySeven(CharacterDto attacker, CharacterDto defender) {
        attackerBasicAttack.attackPlainHit(attacker, defender);
        if (attacker.getLuckySevenSkillCount() > 0) {
            attacker.blockBasicAttack();
            attacker.decrementLuckySevenCount();
        }
    }

    // 상성체크
    public void checkCompatibility(CharacterDto character) {
        if (compatibilityChecker.check(character, character == this.attacker ? this.defender : this.attacker)) {
            compatibilityChecker.increaseAttackerCombatPower(character);
        }
    }



    // attacker vs defender
    public void conductBattle(CharacterDto attacker, CharacterDto defender) {
        checkCompatibility(attacker);
        checkCompatibility(defender);






        while (attacker.getLife() > 0 && defender.getLife() > 0) {
            // 공격자 선
            useAttackerAttackType(attacker, defender);
            
            // 수비자 선

        }
    }
}


//    boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
//        if (hasCompatibility) {
//            compatibilityChecker.increaseAttackerCombatPower(attacker);
//        }


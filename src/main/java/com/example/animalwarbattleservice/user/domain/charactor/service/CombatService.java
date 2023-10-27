package com.example.animalwarbattleservice.user.domain.charactor.service;

import com.example.animalwarbattleservice.compatibility.utill.CompatibilityChecker;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttackImpl;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttackImpl;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.AttackerCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.DefenderCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerBombDropImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveVoidTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerEmergencyFoodImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerLuckySevenImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerDoItAgainImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderBerserkerImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderDefensiveVoidTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderEmergencyFoodImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderLuckySevenImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderSwapImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderUtilityTypeSkill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CombatService extends CharacterDto {
    
    public Integer skillDraw(){
        Random random = new Random(3);
        return random.nextInt();
    }

    public Integer defenseSkillDraw(){
        Random random = new Random(2);
        return random.nextInt();
    }

    // 기본 공격
    private AttackerBasicAttack attackerBasicAttack;
    private DefenderBasicAttack defenderBasicAttack;

    // 공격형 스킬
    private AttackerAttackTypeSkill attackerAttackTypeSkill;
    private DefenderAttackTypeSkill defenderAttackTypeSkill;

    // 수비형 스킬
    private AttackerDefensiveTypeSkill attackerDefensiveTypeSkill;
    private AttackerDefensiveVoidTypeSkill attackerDefensiveVoidTypeSkill;
    private DefenderDefensiveTypeSkill defenderDefensiveTypeSkill;
    private DefenderDefensiveVoidTypeSkill defenderDefensiveVoidTypeSkill;

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
        attackerAttackTypeSkill.execute(attacker, defender);
    }
    public void useDefenderAttackType(CharacterDto attacker, CharacterDto defender){
        defenderAttackTypeSkill.execute(attacker, defender);
    }

    // 수비형 스킬(공격자, 수비자)
    public void useAttackerDefensiveType(CharacterDto attacker, CharacterDto defender){
        attackerDefensiveTypeSkill.execute(attacker, defender);
        attackerDefensiveVoidTypeSkill.execute(attacker, defender);
    }
    public void useDefenderDefensiveType(CharacterDto attacker, CharacterDto defender){
        defenderDefensiveTypeSkill.execute(attacker, defender);
        defenderDefensiveVoidTypeSkill.execute(attacker, defender);
    }

    // 유팅형 스킬(공격자, 수비자)
    public void useAttackerUtilityType(CharacterDto attacker, CharacterDto defender){
        attackerUtilityTypeSkill.execute(attacker, defender);
    }
    public void useDefenderUtilityType(CharacterDto attacker, CharacterDto defender){
        defenderUtilityTypeSkill.execute(attacker, defender);
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

    // 지속성 스킬 체크
    public void  skillPersistenceCheck(CharacterDto attacker, CharacterDto defender){
        if (attacker.getExecutionSkillCount() > 0){useAttackerExecution(attacker, defender);}
        if (attacker.getExecutionSkillCount() > 0){useDefenderExecution(attacker, defender);}
        if (attacker.getIroncladDefenseSkillCount() > 0){useAttackerIroncladDefense(attacker, defender);}
        if (attacker.getIroncladDefenseSkillCount() > 0){useDefenderIroncladDefense(attacker, defender);}
        if (attacker.getIroncladDefenseSkillCount() > 0){useAttackerLuckySeven(attacker, defender);}
        if (attacker.getIroncladDefenseSkillCount() > 0){useDefenderLuckySeven(attacker, defender);}
    }


    // attacker vs defender
    public void conductBattle(CharacterDto attacker, CharacterDto defender) {
        checkCompatibility(attacker);
        checkCompatibility(defender);

        AttackerCharacterDto attackerCharacterDto = new AttackerCharacterDto(
                new AttackerBasicAttackImpl(),
                new AttackerBombDropImpl(),
                new AttackerEmergencyFoodImpl(),
                new AttackerLuckySevenImpl(),
                new AttackerDoItAgainImpl());
        attackerCharacterDto.setNickName("군산 불도저 이세인");
        attackerCharacterDto.changeLife(100000);
        attackerCharacterDto.changeMaxLife(100000);
        attackerCharacterDto.setAttackerPower(200);
        attackerCharacterDto.setAttackTypeSkill("ㅁㄴㅇ");
        attackerCharacterDto.setDefenseTypeSkill("ㅁㄴㅇ");
        attackerCharacterDto.setUtilityTypeSkill("asd");

        DefenderCharacterDto defenderCharacterDto = new DefenderCharacterDto(
                new DefenderBasicAttackImpl(),
                new DefenderBerserkerImpl(),
                new DefenderEmergencyFoodImpl(),
                new DefenderLuckySevenImpl(),
                new DefenderSwapImpl());
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.changeLife(1000000);
        defenderCharacterDto.changeMaxLife(100000);
        defenderCharacterDto.setDefensePower(200);
        defenderCharacterDto.setAttackTypeSkill("ㅁㄴㅇ");
        defenderCharacterDto.setDefenseTypeSkill("");
        defenderCharacterDto.setUtilityTypeSkill("");


        //프론트 공격은 히든, 디펜스 힐, 유틸은 부러진 방패
        AttackerCharacterDto characterDto = new AttackerCharacterDto(new AttackerBasicAttackImpl(),
                new AttackerBombDropImpl(),
                new AttackerEmergencyFoodImpl(),
                new AttackerLuckySevenImpl(),
                new AttackerDoItAgainImpl());

        Integer nowSkillType = skillDraw();

        if  (nowSkillType == 0){
            characterDto.getAttackerAttackTypeSkill().execute( attacker,  defender);
        }
        if  (nowSkillType == 1){

            characterDto.getAttackerUtilityTypeSkill().execute( attacker,  defender);
        }
        if  (nowSkillType == 2){
            nowSkillType = defenseSkillDraw();
            if (nowSkillType == 0){
                characterDto.getAttackerDefensiveVoidTypeSkill();
            }
            if (nowSkillType == 1){
                characterDto.getAttackerDefensiveTypeSkill();
            }
        }
        characterDto.getAttackerAttackTypeSkill().execute(attacker,  defender);
        //지속성 스킬 체크
        skillPersistenceCheck(attacker, defender);

        while (attacker.getLife() > 0 && defender.getLife() > 0) {
            // 공격자의 공격
            useBasicAttack(attacker, defender);
            useAttackerAttackType(attacker, defender);

            // 수비자의 방어
            useBasicDefend(attacker, defender);
            useDefenderDefensiveType(attacker, defender);

            // 스킬 사용
            useAttackerUtilityType(attacker, defender);
            useDefenderUtilityType(attacker, defender);

            // 철통 방어 및 럭키 7 스킬
            useAttackerIroncladDefense(attacker, defender);
            useDefenderLuckySeven(attacker, defender);

            // 처형 스킬
            useAttackerExecution(attacker, defender);
            useDefenderExecution(attacker, defender);

            // 생명력 및 스킬 횟수 감소 확인
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) {
                break;
            }
        }

        // 전투 종료 후 처리
        if (attacker.getLife() <= 0) {
            System.out.println("Attacker has been defeated.");
        } else if (defender.getLife() <= 0) {
            System.out.println("Defender has been defeated.");
        } else {
            System.out.println("The battle resulted in a draw.");
        }
    }
}
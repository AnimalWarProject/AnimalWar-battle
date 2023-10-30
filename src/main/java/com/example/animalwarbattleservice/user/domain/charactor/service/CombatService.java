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
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerBerserkerImpl;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CombatService extends CharacterDto {
    private static final Logger logger = LoggerFactory.getLogger(CombatService.class);

    public CombatService(AttackerBasicAttack attackerBasicAttack, DefenderBasicAttack defenderBasicAttack) {
        this.attackerBasicAttack = attackerBasicAttack;
        this.defenderBasicAttack = defenderBasicAttack;
    }


    public Integer skillDraw(){
        Random random = new Random();
        return random.nextInt(3);
    }

    public Integer defenseSkillDraw(){
        Random random = new Random();
        return random.nextInt(2);
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
    private AttackerCharacterDto attacker;
    private DefenderCharacterDto defender;


    // 기본 공격(공격자, 수비자)
    public void useBasicAttack(AttackerCharacterDto attacker, CharacterDto defender){
        attackerBasicAttack.attackPlainHit(attacker, defender);
    }
    public void useBasicDefend(CharacterDto attacker, DefenderCharacterDto defender){
        defenderBasicAttack.defendPlainHit(attacker, defender);
    }


    // 공격형 스킬(공격자, 수비자)
    public void useAttackerAttackType(AttackerCharacterDto attacker, CharacterDto defender){
        attackerAttackTypeSkill.execute(attacker, defender);
    }
    public void useAttackerDefensiveType(CharacterDto attacker, DefenderCharacterDto defender){
        attackerDefensiveTypeSkill.execute(attacker, defender);
        attackerDefensiveVoidTypeSkill.execute(attacker, defender);
    }



    // 수비형 스킬(공격자, 수비자)
    public void useDefenderAttackType(AttackerCharacterDto attacker, CharacterDto defender){
        defenderAttackTypeSkill.execute(attacker, defender);
    }
    public void useDefenderDefensiveType(CharacterDto attacker, DefenderCharacterDto defender){
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
//    // 버서커 스킬
//    public void attackerBerserker(AttackerCharacterDto attacker, CharacterDto defender) {
//        AttackerAttackTypeSkill berserker = new AttackerBerserkerImpl();
//        berserker.execute(attacker, defender);
//    }

//    // 처형 스킬(공격자, 수비자)
//    public void useAttackerExecution(AttackerCharacterDto attacker, CharacterDto defender) {
//        // 스킬을 사용하는 로직
//        attackerBasicAttack.attackPlainHit(attacker, defender);
//
//        // 스킬 사용 후 피가 깍였을 때, 즉결처형 해야하는지 확인하는 로직이다
//        if (attacker.getExecutionSkillCount() > 0) {
//            if (defender.getLife() <= defender.getMaxLife() / 10) {
//                defender.changeLife(0);
//            }
//            attacker.decrementExecutionCount();
//        }
//    }
//    public void useDefenderExecution(CharacterDto attacker, DefenderCharacterDto defender) {
//        defenderBasicAttack.defendPlainHit(attacker, defender);
//
//        if (defender.getExecutionSkillCount() > 0) {
//            if (attacker.getLife() <= attacker.getLife() / 10) {
//                attacker.changeLife(0);
//            }
//            defender.decrementExecutionCount();
//        }
//    }

//    // 철통 방어(공격자 , 수비자)
//    public void useAttackerIroncladDefense(CharacterDto attacker, DefenderCharacterDto defender) {
//        defenderBasicAttack.defendPlainHit(attacker, defender);
//        if (defender.getIroncladDefenseSkillCount() > 0) {
//            defender.blockBasicAttack();
//            defender.decrementIroncladDefenseCount();
//        }
//    }
//    public void useDefenderIroncladDefense(AttackerCharacterDto attacker, CharacterDto defender) {
//        attackerBasicAttack.attackPlainHit(attacker, defender);
//        if (attacker.getIroncladDefenseSkillCount() > 0) {
//            attacker.blockBasicAttack();
//            attacker.decrementIroncladDefenseCount();
//        }
//    }

//    // 럭키 7 스킬(공격자, 수비자)
//    public void useAttackerLuckySeven(CharacterDto attacker, DefenderCharacterDto defender) {
//        defenderBasicAttack.defendPlainHit(attacker, defender);
//        if (defender.getLuckySevenSkillCount() > 0) {
//            defender.blockBasicAttack();
//            defender.decrementLuckySevenCount();
//        }
//    }
//    public void useDefenderLuckySeven(AttackerCharacterDto attacker, CharacterDto defender) {
//        attackerBasicAttack.attackPlainHit(attacker, defender);
//        if (attacker.getLuckySevenSkillCount() > 0) {
//            attacker.blockBasicAttack();
//            attacker.decrementLuckySevenCount();
//        }
//    }

   // 상성체크
    public void checkCompatibility(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        CompatibilityChecker compatibilityChecker = new CompatibilityChecker();
        boolean isAttackerCompatible = compatibilityChecker.check(attacker, defender);
        boolean isDefenderCompatible = compatibilityChecker.check(defender, attacker);

        if (isAttackerCompatible) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
        } else if (isDefenderCompatible){
            compatibilityChecker.increaseDefenderCombatPower(defender);
        }
    }

//    // 지속성 스킬 체크
//    public void  skillPersistenceCheck(AttackerCharacterDto attacker, DefenderCharacterDto defender){
//        if (attacker.getExecutionSkillCount() > 0){useAttackerExecution(attacker, defender);}
//        if (attacker.getExecutionSkillCount() > 0){useDefenderExecution(attacker, defender);}
//        if (attacker.getIroncladDefenseSkillCount() > 0){useAttackerIroncladDefense(attacker, defender);}
//        if (attacker.getIroncladDefenseSkillCount() > 0){useDefenderIroncladDefense(attacker, defender);}
//        if (attacker.getIroncladDefenseSkillCount() > 0){useAttackerLuckySeven(attacker, defender);}
//        if (attacker.getIroncladDefenseSkillCount() > 0){useDefenderLuckySeven(attacker, defender);}
//    }


    // attacker vs defender
    public void conductBattle(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        logger.info("Battle initiated between Attacker {} and Defender {}", attacker.getNickName(), defender.getNickName());

        //프론트 공격은 히든, 디펜스 힐, 유틸은 부러진 방패
//        int attacker_life = 10;
//        int defender_life = 10;
//
//        List<String> plan;
//
//        while( attacker_life > 0 && defender_life > 0 ){
//            // 1 event : 공격자가 수비자에게 공격
//            if defender_life 상태를체크해서
//                    //먼저 랜덤하게 뽑는거다.
//            // 스텝별로 기본 공격부터 시작해보자!!,, 버서커 확률이 70이면 , 나머지는 가중치 30으로 줘라???
//            List<int> attacker_plan = new List<int>();
//            attacker_plan.add(
//                    0,공격할거냐 말거냐
//            )
//                    attacker_plan.add(1, 스킬쓸거나 말거냐)
//                             attacker_plan.add(
//                                     2, 스킬을 쓸거냐 말거냐
//                             )
//
//            attacke attack = attacker_plan.get(random())
//            defender_life -= attacker_attack
//            plan.add("공격자가 수비자에게 " + attacker_attack + " 만큼 기본공격을 했습니다.")
//        }
        checkCompatibility(attacker, defender);//
        logger.info("attacker power = " + attacker.getAttackerPower());
        logger.info("defender power = " + defender.getDefensePower());


        while (attacker.getLife() > 0 && defender.getLife() > 0) {


            // 공격자의 기본공격
            int a = attackerBasicAttack.attackPlainHit(attacker, defender);
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            defender.changeLife(defender.getLife()-a);
                System.out.println("기본 공격 맞은 수비자 체력====>" + defender.getLife());
            skillExecute(attacker, defender);
                System.out.println("스킬을 맞은 수비자체력====>" + defender.getLife());
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) {
                break;
            }

            // 수비자의 기본공격
            int b = defenderBasicAttack.defendPlainHit(attacker, defender);
            attacker.changeLife(attacker.getLife()-b);
                System.out.println("기본 공격 받은 공격자 체력====>" + attacker.getLife());
            skillExecute(attacker, defender);
                System.out.println("스킬맞은 공격자체력====>" + attacker.getLife());
            // 생명력 및 스킬 횟수 감소 확인
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) {
                break;
            }
        }
        logger.info("싸움 종료 ");
        logger.info("Attacker life: " + attacker.getLife());
        logger.info("Defender life: " + defender.getLife());


        // 전투 종료 후 처리
        if (attacker.getLife() <= 0) {
            logger.info("Attacker has been defeated.");
        } else if (defender.getLife() <= 0) {
            logger.info("Defender has been defeated.");
        } else {
            logger.info("The battle resulted in a draw.");
        }
        logger.info("Battle concluded");


    }
    private boolean skillExecuted = false;

    private void skillExecute(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        Integer nowSkillType = -1;
//        if(!skillExecuted)
        nowSkillType = skillDraw();
        System.out.println("skillType = " + nowSkillType);

        if  (nowSkillType == 0){
            attacker.getAttackerAttackTypeSkill().execute(attacker, defender);
            System.out.println("스킬발동");
            defender.getDefenderAttackTypeSkill().execute(attacker, defender);
            System.out.println("스킬발동");



            System.out.println(1);
        }
        if  (nowSkillType == 1){

            attacker.getAttackerUtilityTypeSkill().execute(attacker, defender);
            defender.getDefenderUtilityTypeSkill().execute(attacker, defender);
            System.out.println(2);
        }
        if  (nowSkillType == 2){
            nowSkillType = defenseSkillDraw();
            if (nowSkillType == 0){
                attacker.getAttackerDefensiveVoidTypeSkill().execute(attacker, defender);
                defender.getDefenderDefensiveVoidTypeSkill().execute(attacker, defender);
                System.out.println(3);
            }
            if (nowSkillType == 1){
                attacker.getAttackerDefensiveTypeSkill().execute(attacker, defender);
                defender.getDefenderDefensiveTypeSkill().execute(attacker, defender);
                System.out.println(4);
            }
        }
//        skillPersistenceCheck(attacker, defender);
    }
}
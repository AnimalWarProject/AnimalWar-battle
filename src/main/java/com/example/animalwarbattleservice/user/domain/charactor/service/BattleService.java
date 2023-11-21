package com.example.animalwarbattleservice.user.domain.charactor.service;

import com.example.animalwarbattleservice.compatibility.utill.CompatibilityChecker;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.BasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.StateDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.UtilityTypeSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BattleService extends CharacterDto {
    private static final Logger logger = LoggerFactory.getLogger(BattleService.class);

    public BattleService(BasicAttack basicAttack) {
        this.basicAttack = basicAttack;
    }

    public Integer skillDraw() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private StateDto stateDto;
    // 기본 공격
    private BasicAttack basicAttack;
    // 공격형 스킬
    private AttackTypeSkill attackTypeSkill;
    // 수비형 스킬
    private DefensiveTypeSkill defensiveTypeSkill;
    // 유틸형 스킬
    private UtilityTypeSkill utilityTypeSkill;
    // 상성체크
    private CompatibilityChecker compatibilityChecker;


    // 상성체크
    public void checkCompatibility(CharacterDto attacker, CharacterDto defender) {
        CompatibilityChecker compatibilityChecker = new CompatibilityChecker();
        boolean isAttackerCompatible = compatibilityChecker.check(attacker, defender);
        boolean isDefenderCompatible = compatibilityChecker.check(defender, attacker);

        if (isAttackerCompatible) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
        } else if (isDefenderCompatible) {
            compatibilityChecker.increaseDefenderCombatPower(defender);
        }
    }

    // attacker vs defender
    public List<String> conductBattle(CharacterDto attacker, CharacterDto defender) {
        stateDto = new StateDto();
        List<String> battleLogs = new ArrayList<>();
        checkCompatibility(attacker, defender);
        startBattleLogs(attacker, defender, battleLogs);


        while (attacker.getLife() > 0 && defender.getLife() > 0) {

            // 공격자 턴
            Integer BeforeAttackedDefenderLife = defender.getLife();
            plainHit(attacker, defender);
            attackerLogsBasicAttack(attacker, defender, battleLogs);
            attackerSkillUsed(attacker, defender);

            band(defender);
            checkRustedSword(defender, BeforeAttackedDefenderLife);

            nowState(attacker, defender, battleLogs);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(defender);
            discountBasicAttack(attacker);

            // 수비자 턴
            Integer BeforeAttackedAttackerLife = attacker.getLife();
            plainHit(defender, attacker);
            defenderLogsBasicAttack(attacker, defender, battleLogs);
            defenderSkillUsed(defender, attacker);

            band(attacker);
            checkRustedSword(attacker, BeforeAttackedAttackerLife);

            nowState(attacker, defender, battleLogs);

            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(attacker);
            discountBasicAttack(defender);
        }
        battleLogs.add("싸움 종료 ");
        battleLogs.add("Attacker life: " + attacker.getLife());
        battleLogs.add("Defender life: " + defender.getLife());


        // 전투 종료 후 처리
        if (attacker.getLife() <= 0) {
            battleLogs.add("Attacker has been defeated.");
        } else if (defender.getLife() <= 0) {
            battleLogs.add("Defender has been defeated.");
        } else {
            battleLogs.add("The battle resulted in a draw.");
        }
        battleLogs.add("Battle concluded");

        return battleLogs;
}
    // 전투 상태 로그
    private static void startBattleLogs(CharacterDto attacker, CharacterDto defender, List<String> battleLogs) {
        battleLogs.add("Attacker {}님이 Defender {}을 침공하여 전투가 시작되었습니다." + attacker.getNickName() + defender.getNickName());
        battleLogs.add("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        battleLogs.add("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        battleLogs.add("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        battleLogs.add("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("공격자 이름 : "+ attacker.getNickName());
        battleLogs.add("공격자 종족 : "+ attacker.getCompatibilityEnum());
        battleLogs.add(attacker.getNickName() + " 님 체력 : " + attacker.getLife());
        battleLogs.add(attacker.getNickName() + " 님 공격력 : " + attacker.getAttackPower());
        battleLogs.add(attacker.getNickName() + " 님 방어력 : " + attacker.getDefensePower());
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("---------------------------------------------------------------------------------------------------------------");
        battleLogs.add("수비자 이름 : "+ defender.getNickName());
        battleLogs.add("수비자 종족 : "+ defender.getCompatibilityEnum());
        battleLogs.add(defender.getNickName() + " 님 체력 : " + defender.getLife());
        battleLogs.add(defender.getNickName() + " 님 공격력 : " + defender.getAttackPower());
        battleLogs.add(defender.getNickName() + " 님 방어력 : " + defender.getDefensePower());
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
        battleLogs.add("======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======전투 시작======");
    }

    // 현재 상태 로그
    private static void nowState(CharacterDto attacker, CharacterDto defender, List<String> battleLogs){
        battleLogs.add("==================공격자 배틀 power ================== " + attacker.getAttackPower());
        battleLogs.add("==================수비자 배틀 power ================== " + defender.getAttackPower());
        battleLogs.add("================== 공격자 현재체력 ==================  " + attacker.getLife());
        battleLogs.add("================== 수비자 현재체력 ==================  " + defender.getLife());
    }
    
    
    //  기본 공격 로그
    private static void attackerLogsBasicAttack(CharacterDto attacker, CharacterDto defender, List<String> battleLogs){
        battleLogs.add(attacker.getNickName() + " 평타 톡!");
    }
    private static void defenderLogsBasicAttack(CharacterDto attacker, CharacterDto defender, List<String> battleLogs) {
        battleLogs.add(defender.getNickName() + " 평타 톡!");
    }

    // 버서커 체크
    public void checkBerserker(CharacterDto characterDto){
        if (characterDto.isBerserkerActivated() &&
                characterLifeCheck(characterDto) &&
                !characterDto.isBerserkerUsed()){
            characterDto.changeBerserkerUsed();
            characterDto.changeBattlePower(characterDto.getAttackPower() * 3);
        }
    }
    // 버서커 스킬, 유저 체력 체크
    public boolean characterLifeCheck(CharacterDto characterDto){
        if ((double)characterDto.getMaxLife() *0.2 >= characterDto.getLife()) {
            return true;
        }
        return  false;
    }
    
    // 녹슨 방패 스킬
    public void checkRustedSword(CharacterDto attacker, Integer beforAttackedLife) {
        Integer battleLostLife = beforAttackedLife - attacker.getLife();
        Integer healAmount = (int) (0.1 * battleLostLife);
        if (attacker.isRustedSwordActivated()){
            attacker.changeLife(attacker.getLife() + healAmount);
        }
    }

    // 붕대 감기 스킬
    public void band(CharacterDto attacker){
        Integer battleLostLife = attacker.getMaxLife() - attacker.getLife();
        Integer healAmount = (int) (0.07 * battleLostLife);
        if (attacker.isBandingHeal() != 0) {
            attacker.changeLife(attacker.getLife() + healAmount);
            attacker.decreaseBandingCheck();
        }
    }

    // 기본 공격
    private Integer plainHit(CharacterDto attacker, CharacterDto defender) {
        int a = basicAttack.plainHit(attacker, defender);
        defender.changeLife(defender.getLife() - a);
        return null;
    }

    public void discountBasicAttack(CharacterDto characterDto){
        if (characterDto.isBasicAttack() != 0) characterDto.decreaseBasicAttack();
    }

    // 공격자 스킬
    public void attackerSkillUsed(CharacterDto attacker, CharacterDto defender) {
        Integer returnDamage = attackerSkillExecute(attacker, defender);
        if (returnDamage != 0){
            defender.changeLife(defender.getLife() - returnDamage);
        }
    }

    // 수비자 스킬
    public void defenderSkillUsed(CharacterDto defender, CharacterDto attacker) {
        Integer returnDamage = defenderSkillExecute(defender, attacker);
        if (returnDamage != 0){
            attacker.changeLife(attacker.getLife() - returnDamage);
        }
    }

    // 스킬 한 번 적용


    private Integer attackerSkillExecute(CharacterDto attacker, CharacterDto defender) {
        Integer returnAttackerDamage = 0;
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();
        System.out.println(attacker.getNickName());
        System.out.println(nowSkillType);
        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!stateDto.isAttackerAttackUsed()) {
                if (attacker.getAttackTypeSkill() != null) {
                    returnAttackerDamage = attacker.getAttackTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getAttackTypeSkill());
                    stateDto.setAttackerAttackUsed(true);
                }
            }
        } else if (nowSkillType == 1) {
            if (!stateDto.isAttackerUtilityTypeUsed()) {
                if (attacker.getUtilityTypeSkill() != null) {
                    attacker.getUtilityTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getUtilityTypeSkill());
                    stateDto.setAttackerUtilityTypeUsed(true);
                }
            }
        } else if (nowSkillType == 2) {
            if (!stateDto.isAttackerDefensiveTypeUsed()) {
                if (attacker.getDefenseTypeSkill() != null) {
                    attacker.getDefenseTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getDefenseTypeSkill());
                    stateDto.setAttackerDefensiveTypeUsed(true);
                }
            }
        }
        return returnAttackerDamage;
    }

    private Integer defenderSkillExecute(CharacterDto defender, CharacterDto attacker) {
        Integer returnDefenderDamage = 0;
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();

        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!stateDto.isDefenderAttackUsed()) {
                if (defender.getAttackTypeSkill() != null) {
                    returnDefenderDamage  = defender.getAttackTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getAttackTypeSkill());
                    stateDto.setDefenderAttackUsed(true);
                }
            }
        } else if (nowSkillType == 1) {
            if (!stateDto.isDefenderUtilityTypeUsed()) {
                if (defender.getUtilityTypeSkill() != null) {
                    defender.getUtilityTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getUtilityTypeSkill());
                    stateDto.setDefenderUtilityTypeUsed(true);
                }
            }
        } else if (nowSkillType == 2) {
            if (!stateDto.isDefenderDefensiveTypeUsed()) {
                if (defender.getDefenseTypeSkill() != null) {
                    defender.getDefenseTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getDefenseTypeSkill());
                    stateDto.setDefenderDefensiveTypeUsed(true);
                }
            }
        }
        return returnDefenderDamage;
    }
}
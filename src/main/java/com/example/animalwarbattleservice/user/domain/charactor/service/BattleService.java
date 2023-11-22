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
            basicAttackLogs(attacker, defender, battleLogs);

            attackerSkillUsed(attacker, defender, battleLogs);

            band(defender);
            checkRustedSword(defender, BeforeAttackedDefenderLife);

            nowState(attacker, defender, battleLogs);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(defender);
            discountBasicAttack(attacker);

            // 수비자 턴
            Integer BeforeAttackedAttackerLife = attacker.getLife();
            plainHit(defender, attacker);
            basicAttackLogs(defender, attacker, battleLogs);

            defenderSkillUsed(defender, attacker, battleLogs);

            band(attacker);
            checkRustedSword(attacker, BeforeAttackedAttackerLife);

            nowState(attacker, defender, battleLogs);

            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(attacker);
            discountBasicAttack(defender);
        }
        battleLogs.add("싸움 종료 ");
        battleLogs.add("⚔️⚔️⚔️ 공격자 체력: " + attacker.getLife());
        battleLogs.add("🛡️🛡️🛡️수비자 체력: " + defender.getLife());


        // 전투 종료 후 처리
        battleLogs.add("전투 결과");
        if (attacker.getLife() <= 0) {
            battleLogs.add("🏳️🏳️🏳️ "+attacker.getNickName() + "님이 패배했습니다." + " 🏳️🏳️🏳️");
        } else if (defender.getLife() <= 0) {
            battleLogs.add("🏳️🏳️🏳️ "+defender.getNickName() + "님이 패배했습니다." + " 🏳️🏳️🏳️");
        } else {
            battleLogs.add("비겼습니다.");
        }

        return battleLogs;
    }
    // 전투 상태 로그
    private static void startBattleLogs(CharacterDto attacker, CharacterDto defender, List<String> battleLogs) {
        battleLogs.add(attacker.getNickName() + " 쉐이가" + defender.getNickName() + "님의 지형을 침공했다.");
        battleLogs.add(attacker.getNickName() + " 쉐이가" + defender.getNickName() + "님의 지형을 침공했다.");
        battleLogs.add(attacker.getNickName() + " 쉐이가" + defender.getNickName() + "님의 지형을 침공했다.");
        battleLogs.add("공격자 이름 : "+ attacker.getNickName());
        battleLogs.add("공격자 종족 : "+ attacker.getCompatibilityEnum());
        battleLogs.add(attacker.getNickName() + " 님 체력 : " + attacker.getLife());
        battleLogs.add(attacker.getNickName() + " 님 공격력 : " + attacker.getAttackPower());
        battleLogs.add(attacker.getNickName() + " 님 방어력 : " + attacker.getDefensePower());
        battleLogs.add("-----------------------------------------------------------------------------------------------");
        battleLogs.add("수비자 이름 : "+ defender.getNickName());
        battleLogs.add("수비자 종족 : "+ defender.getCompatibilityEnum());
        battleLogs.add(defender.getNickName() + " 님 체력 : " + defender.getLife());
        battleLogs.add(defender.getNickName() + " 님 공격력 : " + defender.getAttackPower());
        battleLogs.add(defender.getNickName() + " 님 방어력 : " + defender.getDefensePower());
        battleLogs.add("===전투가 시작됩니다.===");
        battleLogs.add("===전투가 시작됩니다.===");
        battleLogs.add("===전투가 시작됩니다.===");
       }

    // 현재 상태 로그
    private static void nowState(CharacterDto attacker, CharacterDto defender, List<String> battleLogs){
        battleLogs.add("⚔️⚔️⚔️========공격자 현재체력: " + attacker.getLife());
        battleLogs.add("🛡️🛡️🛡️========수비자 현재체력: " + defender.getLife());
    }
    
    
    //  기본 공격 로그
    private static void basicAttackLogs(CharacterDto attacker, CharacterDto defender, List<String> battleLogs){
        battleLogs.add("👊👊👊 " + attacker.getNickName() + " 쉐이가 때림!");
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
    public void attackerSkillUsed(CharacterDto attacker, CharacterDto defender, List<String> battleLogs) {
        Integer returnDamage = attackerSkillExecute(attacker, defender, battleLogs);
        if (returnDamage != 0){
            defender.changeLife(defender.getLife() - returnDamage);
        }
    }

    // 수비자 스킬
    public void defenderSkillUsed(CharacterDto defender, CharacterDto attacker, List<String> battleLogs) {
        Integer returnDamage = defenderSkillExecute(defender, attacker, battleLogs);
        if (returnDamage != 0){
            attacker.changeLife(attacker.getLife() - returnDamage);
        }
    }

    // 스킬 한 번 적용


    private Integer attackerSkillExecute(CharacterDto attacker, CharacterDto defender, List<String> battleLogs) {
        Integer returnAttackerDamage = 0;
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();
        String attackSkill = attacker.getStringAttackTypeSkill();
        String defenseSkill = attacker.getStringDefenseTypeSkill();
        String utilitySkill = attacker.getStringUtilityTypeSkill();

        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!stateDto.isAttackerAttackUsed()) {
                if (attacker.getAttackTypeSkill() != null) {
                    returnAttackerDamage = attacker.getAttackTypeSkill().execute(attacker, defender);
                    battleLogs.add("🧙️🧙️🧙️ "+ attacker.getNickName() + "의 공격형 스킬" + attackSkill + " 발동");
                    stateDto.setAttackerAttackUsed(true);
                }
            }
        } else if (nowSkillType == 1) {
            if (!stateDto.isAttackerUtilityTypeUsed()) {
                if (attacker.getUtilityTypeSkill() != null) {
                    attacker.getUtilityTypeSkill().execute(attacker, defender);
                    battleLogs.add("🧙‍♂️🧙‍♂️🧙‍♂️ "+attacker.getNickName() + "의 유틸형 스킬" + utilitySkill + " 발동");
                    stateDto.setAttackerUtilityTypeUsed(true);
                }
            }
        } else if (nowSkillType == 2) {
            if (!stateDto.isAttackerDefensiveTypeUsed()) {
                if (attacker.getDefenseTypeSkill() != null) {
                    attacker.getDefenseTypeSkill().execute(attacker, defender);
                    battleLogs.add("🧙🧙🧙 "+attacker.getNickName() + "의 방어형 스킬" + defenseSkill + " 발동");
                    stateDto.setAttackerDefensiveTypeUsed(true);
                }
            }
        }
        return returnAttackerDamage;
    }

    private Integer defenderSkillExecute(CharacterDto defender, CharacterDto attacker, List<String> battleLogs) {
        Integer returnDefenderDamage = 0;
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();
        String attackSkill = defender.getStringAttackTypeSkill();
        String defenseSkill = defender.getStringDefenseTypeSkill();
        String utilitySkill = defender.getStringUtilityTypeSkill();

        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!stateDto.isDefenderAttackUsed()) {
                if (defender.getAttackTypeSkill() != null) {
                    returnDefenderDamage  = defender.getAttackTypeSkill().execute(defender, attacker);
                    battleLogs.add("🧙️🧙️🧙️ "+defender.getNickName() + "의 공격형 스킬" + attackSkill + " 발동");
                    stateDto.setDefenderAttackUsed(true);
                }
            }
        } else if (nowSkillType == 1) {
            if (!stateDto.isDefenderUtilityTypeUsed()) {
                if (defender.getUtilityTypeSkill() != null) {
                    defender.getUtilityTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getUtilityTypeSkill());
                    battleLogs.add("🧙‍♂️🧙‍♂️🧙‍♂️ "+defender.getNickName() + "의 유틸형 스킬" + utilitySkill + " 발동");
                    stateDto.setDefenderUtilityTypeUsed(true);
                }
            }
        } else if (nowSkillType == 2) {
            if (!stateDto.isDefenderDefensiveTypeUsed()) {
                if (defender.getDefenseTypeSkill() != null) {
                    defender.getDefenseTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getDefenseTypeSkill());
                    battleLogs.add("🧙🧙🧙 "+defender.getNickName() + "의 방어형 스킬" + defenseSkill + " 발동");
                    stateDto.setDefenderDefensiveTypeUsed(true);
                }
            }
        }
        return returnDefenderDamage;
    }
}
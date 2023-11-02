package com.example.animalwarbattleservice.user.domain.charactor.service;

import com.example.animalwarbattleservice.compatibility.utill.CompatibilityChecker;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.BasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.UtilityTypeSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class BattleService extends CharacterDto {
    private static final Logger logger = LoggerFactory.getLogger(BattleService.class);

    public BattleService(BasicAttack basicAttack) {
        this.basicAttack = basicAttack;
    }

    public Integer skillDraw(){
        Random random = new Random();
        return random.nextInt(3);
    }

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
        } else if (isDefenderCompatible){
            compatibilityChecker.increaseDefenderCombatPower(defender);
        }
    }


    // attacker vs defender
    public void conductBattle(CharacterDto attacker, CharacterDto defender) {
        checkCompatibility(attacker, defender);
        printStartMessage(attacker, defender);
        while (attacker.getLife() > 0 && defender.getLife() > 0) {
            // 공격자 턴
            attackerPlainHit(attacker, defender);
            AttackerSkillUsed(attacker, defender);
            printNowPower(attacker, defender);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(defender);
            discountBasicAttack(attacker);

            // 수비자 턴
            defenderPlainHit(defender, attacker);
            DefenderSkillExecute(defender, attacker);
            printNowPower(attacker, defender);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(attacker);
            discountBasicAttack(defender);
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


    public void checkBerserker(CharacterDto characterDto){
        if (characterDto.isBerserkerActivated() &&
                characterLifeCheck(characterDto) &&
                !characterDto.isBusuckerUsed()){
            characterDto.changeBusuckerUsed();
            characterDto.changeBattlePower(characterDto.getBattlePower() * 3);
        }
    }

    public void printStartMessage(CharacterDto attacker, CharacterDto defender) {
        logger.info("Battle initiated between Attacker {} and Defender {}", attacker.getNickName(), defender.getNickName());
        System.out.println("======= 공격자 전투력 =======  " + attacker.getBattlePower());
        System.out.println("======= 수비자 전투력 =======  " + defender.getBattlePower());
        System.out.println("======= 공격자 체력 =======  " + attacker.getLife());
        System.out.println("======= 수비자 체력 =======  " + defender.getLife());
        System.out.println("======= 공격자 이름 =======  "+ attacker.getNickName());
        System.out.println("======= 수비자 이름 =======  "+ defender.getNickName());
        System.out.println("==========전투 시작============================== 전투 시작 =======================전투 시작=================  ");
        System.out.println("========================================" + attacker.getNickName() + "님이 침략했습니다. ======================================== ");
    }

    public void printNowPower(CharacterDto attacker, CharacterDto defender) {
        System.out.println("==================공격자 배틀 power = " + attacker.getBattlePower());
        System.out.println("==================수비자배틀 power = " + defender.getBattlePower());
        System.out.println("==================공격자 수비력 power = " + attacker.getDefendPower());
        System.out.println("==================수비자 수비력 power = " + defender.getDefendPower());
    }

    private void defenderPlainHit(CharacterDto defender, CharacterDto attacker) {
        int b = basicAttack.plainHit(defender, attacker);
        attacker.changeLife(attacker.getLife() - b);
        System.out.println("수비자평타 이후,,,,  공격자체력 " + attacker.getLife());
        System.out.println("수비자평타 이후,,,,  수비자체력 " + defender.getLife());
    }

    private void attackerPlainHit(CharacterDto attacker, CharacterDto defender) {
        int a = basicAttack.plainHit(attacker, defender);
        defender.changeLife(defender.getLife() - a);
        System.out.println("공격자평타 이후,,,,  공격자체력 " + attacker.getLife());
        System.out.println("공격자평타 이후,,,,  수비자 체력 " + defender.getLife());
    }

    public void discountBasicAttack(CharacterDto characterDto){
        if (characterDto.isBasicAttack() != 0) characterDto.decreaseBasicAttack();
    }

    public boolean characterLifeCheck(CharacterDto characterDto){
        if ((double)characterDto.getMaxLife() *0.2 >= characterDto.getLife()) {
            return true;
        }
        return  false;
    }

    public void AttackerSkillUsed(CharacterDto attacker, CharacterDto defender) {
        Integer returnDamage = attackerSkillExecute(attacker, defender);
        if (returnDamage != 0){
            System.out.println("공격자 스킬 수치======" + returnDamage);
            defender.changeLife(defender.getLife() - returnDamage);
        }
    }

    public void DefenderSkillExecute(CharacterDto defender, CharacterDto attacker) {
        Integer returnDamage = defenderSkillExecute(defender, attacker);
        if (returnDamage != 0){
            System.out.println("수비자 스킬 수치======" + returnDamage);
            attacker.changeLife(attacker.getLife() - returnDamage);
        }
    }



    public
    int battleLostLife = attacker.getMaxLife() - attacker.getLife();
    int healAmount = (int) (0.07 * battleLostLife);
                attacker.changeLife(attacker.getLife() + healAmount);

    private boolean attackerAttackUsed = false;
    private boolean attackerDefensiveTypeUsed = false;
    private boolean attackerUtilityTypeUsed = false;
    private boolean defenderAttackUsed = false;
    private boolean defenderDefensiveTypeUsed = false;
    private boolean defenderUtilityTypeUsed = false;

    private Integer attackerSkillExecute(CharacterDto attacker, CharacterDto defender) {
        Integer returnAttackerDamage = 0;
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();
        System.out.println(attacker.getNickName());
        System.out.println(nowSkillType);
        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!attackerAttackUsed) {
                if (attacker.getAttackTypeSkill() != null) {
                    returnAttackerDamage = attacker.getAttackTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getAttackTypeSkill());
                    attackerAttackUsed = true;
                }
            }
        } else if (nowSkillType == 1) {
            if (!attackerUtilityTypeUsed) {
                if (attacker.getUtilityTypeSkill() != null) {
                    attacker.getUtilityTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getUtilityTypeSkill());
                    attackerUtilityTypeUsed = true;
                }
            }
        } else if (nowSkillType == 2) {
            if (!attackerDefensiveTypeUsed) {
                if (attacker.getDefenseTypeSkill() != null) {
                    attacker.getDefenseTypeSkill().execute(attacker, defender);
                    System.out.println("======공격자" + attacker.getDefenseTypeSkill());
                    attackerDefensiveTypeUsed = true;
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
            if (!defenderAttackUsed) {
                if (defender.getAttackTypeSkill() != null) {
                    returnDefenderDamage  = defender.getAttackTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getAttackTypeSkill());
                    defenderAttackUsed = true;
                }
            }
        } else if (nowSkillType == 1) {
            if (!defenderUtilityTypeUsed) {
                if (defender.getUtilityTypeSkill() != null) {
                    defender.getUtilityTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getUtilityTypeSkill());
                    defenderUtilityTypeUsed = true;
                }
            }
        } else if (nowSkillType == 2) {
            if (!defenderDefensiveTypeUsed) {
                if (defender.getDefenseTypeSkill() != null) {
                    defender.getDefenseTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getDefenseTypeSkill());
                    defenderDefensiveTypeUsed = true;
                }
            }
        }
        return returnDefenderDamage;
    }
}
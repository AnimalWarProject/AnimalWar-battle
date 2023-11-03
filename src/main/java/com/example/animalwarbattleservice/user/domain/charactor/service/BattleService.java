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
            Integer BeforeAttackedDefenderLife = defender.getLife();
            plainHit(attacker, defender);
            attackerPrintBasicAttack(attacker, defender);
            attackerSkillUsed(attacker, defender);

            band(defender);
            checkRustedSword(defender, BeforeAttackedDefenderLife);

            printNowPower(attacker, defender);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) break;
            checkBerserker(defender);
            discountBasicAttack(attacker);

            // 수비자 턴
            Integer BeforeAttackedAttackerLife = attacker.getLife();
            plainHit(defender, attacker);
            defenderPrintBasicAttack(attacker, defender);
            defenderSkillUsed(defender, attacker);

            band(attacker);
            checkRustedSword(attacker, BeforeAttackedAttackerLife);

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
    // 전투 상태 프린트
    public void printStartMessage(CharacterDto attacker, CharacterDto defender) {
        logger.info("Battle initiated between Attacker {} and Defender {}", attacker.getNickName(), defender.getNickName());
        System.out.println("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        System.out.println("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        System.out.println("====== " + attacker.getNickName() + " 님이 침략했습니다. ====== " + "====== "  + attacker.getNickName() + "====== ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("공격자 이름 : "+ attacker.getNickName());
        System.out.println("공격자 종족 : "+ attacker.getCompatibilityEnum());
        System.out.println(attacker.getNickName() + " 님 체력 : " + attacker.getLife());
        System.out.println(attacker.getNickName() + " 님 공격력 : " + attacker.getBattlePower());
        System.out.println(attacker.getNickName() + " 님 방어력 : " + attacker.getDefendPower());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("수비자 이름 : "+ defender.getNickName());
        System.out.println("수비자 종족 : "+ defender.getCompatibilityEnum());
        System.out.println(defender.getNickName() + " 님 체력 : " + defender.getLife());
        System.out.println(defender.getNickName() + " 님 공격력 : " + defender.getBattlePower());
        System.out.println(defender.getNickName() + " 님 방어력 : " + defender.getDefendPower());
        System.out.println("=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========  ");
        System.out.println("=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========  ");
        System.out.println("=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========  ");
        System.out.println("=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========  ");
        System.out.println("=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========전투 시작=========  ");
    }
    public void printNowPower(CharacterDto attacker, CharacterDto defender) {
        System.out.println("==================공격자 배틀 power ================== " + attacker.getBattlePower());
        System.out.println("==================수비자 배틀 power ================== " + defender.getBattlePower());
        System.out.println("================== 공격자 현재체력 ==================  " + attacker.getLife());
        System.out.println("================== 수비자 현재체력 ==================  " + defender.getLife());

    }
    public void attackerPrintBasicAttack(CharacterDto attacker, CharacterDto defender) {
        System.out.println(attacker.getNickName() + " 평타 톡!");
    }
    public void defenderPrintBasicAttack(CharacterDto attacker, CharacterDto defender) {
        System.out.println(defender.getNickName() + " 평타 톡!");
    }

    // 버서커 체크
    public void checkBerserker(CharacterDto characterDto){
        if (characterDto.isBerserkerActivated() &&
                characterLifeCheck(characterDto) &&
                !characterDto.isBerserkerUsed()){
            characterDto.changeBerserkerUsed();
            characterDto.changeBattlePower(characterDto.getBattlePower() * 3);
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
        System.out.println("녹슨 방패 쓰기 전 " + attacker.getNickName() + ",,,체력 " + attacker.getLife());
        if (attacker.isRustedSwordActivated()){
            attacker.changeLife(attacker.getLife() + healAmount);
            System.out.println("녹슨 방패 쓰고나서 " + attacker.getNickName() + ",,,체력 " + attacker.getLife());
        }
    }

    // 붕대 감기 스킬
    public void band(CharacterDto attacker){
        Integer battleLostLife = attacker.getMaxLife() - attacker.getLife();
        Integer healAmount = (int) (0.07 * battleLostLife);
//        System.out.println("붕대 감기 쓰기 전 " + attacker.getNickName() + ",,,체력 " + attacker.getLife());
        if (attacker.isBandingHeal() != 0) {
            attacker.changeLife(attacker.getLife() + healAmount);
            attacker.decreaseBandingCheck();
//        System.out.println("붕대 감기 쓰고 나서 " + attacker.getNickName() + ",,,체력 " + attacker.getLife());
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
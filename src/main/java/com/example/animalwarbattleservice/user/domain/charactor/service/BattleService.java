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
        logger.info("Battle initiated between Attacker {} and Defender {}", attacker.getNickName(), defender.getNickName());
        checkCompatibility(attacker, defender);//
        System.out.println("attacker power = " + attacker.getBattlePower());
        System.out.println("defender power = " + defender.getBattlePower());
        System.out.println("attacker Name = "+ attacker.getNickName());
        System.out.println("defender Name = "+ defender.getNickName());

        while (attacker.getLife() > 0 && defender.getLife() > 0) {
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            System.out.println("==================attacker power = " + attacker.getBattlePower());
            System.out.println("==================defender power = " + defender.getBattlePower());
            // 공격자 턴
            int a = basicAttack.plainHit(attacker, defender);
            defender.changeLife(defender.getLife() -a);
            AttackerSkillUsed(attacker, defender);
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) {
                break;
            }

            // 수비자 턴
            int b = basicAttack.plainHit(defender, attacker);
            attacker.changeLife(attacker.getLife() -b);
            DefenderSkillExecute(defender, attacker);
//            DefenderSkillExecute(defender, attacker);
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            System.out.println("==================attacker power = " + attacker.getBattlePower());
            System.out.println("==================defender power = " + defender.getBattlePower());
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

    public void AttackerSkillUsed(CharacterDto attacker, CharacterDto defender) {
        Integer returnDamage = attackerSkillExecute(attacker, defender);
        if (returnDamage != 0){
            System.out.println("공격자 스킬데미지======" + returnDamage);
            defender.changeLife(defender.getLife() - returnDamage);
        }
    }

    public void DefenderSkillExecute(CharacterDto defender, CharacterDto attacker) {
        Integer returnDamage = defenderSkillExecute(defender, attacker);
        if (returnDamage != 0){
            System.out.println("수비자 스킬데미지======" + returnDamage);
            attacker.changeLife(attacker.getLife() - returnDamage);
        }
    }

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
                    System.out.println("======수비자" + defender.getDefenseTypeSkill());
                    defenderUtilityTypeUsed = true;
                }
            }
        } else if (nowSkillType == 2) {
            if (!defenderDefensiveTypeUsed) {
                if (defender.getDefenseTypeSkill() != null) {
                    defender.getDefenseTypeSkill().execute(defender, attacker);
                    System.out.println("======수비자" + defender.getUtilityTypeSkill());
                    defenderDefensiveTypeUsed = true;
                }
            }
        }
        return returnDefenderDamage;
    }
}
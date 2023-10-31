package com.example.animalwarbattleservice.user.domain.charactor.service;

import com.example.animalwarbattleservice.compatibility.utill.CompatibilityChecker;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.AttackerCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.DefenderCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderUtilityTypeSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
    }

    // 수비형 스킬(공격자, 수비자)
    public void useDefenderAttackType(AttackerCharacterDto attacker, CharacterDto defender){
        defenderAttackTypeSkill.execute(attacker, defender);
    }
    public void useDefenderDefensiveType(CharacterDto attacker, DefenderCharacterDto defender){
        defenderDefensiveTypeSkill.execute(attacker, defender);
    }

    // 유팅형 스킬(공격자, 수비자)
    public void useAttackerUtilityType(CharacterDto attacker, CharacterDto defender){
        attackerUtilityTypeSkill.execute(attacker, defender);
    }
    public void useDefenderUtilityType(CharacterDto attacker, CharacterDto defender){
        defenderUtilityTypeSkill.execute(attacker, defender);
    }

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


    // attacker vs defender
    public void conductBattle(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        logger.info("Battle initiated between Attacker {} and Defender {}", attacker.getNickName(), defender.getNickName());
        checkCompatibility(attacker, defender);//
        System.out.println("attacker power = " + attacker.getAttackerPower());
        System.out.println("defender power = " + defender.getDefensePower());

        while (attacker.getLife() > 0 && defender.getLife() > 0) {
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            System.out.println("==================attacker power = " + attacker.getAttackerPower());
            System.out.println("==================defender power = " + defender.getDefensePower());
            // 공격자 턴
            int a = attackerBasicAttack.attackPlainHit(attacker, defender);
            defender.changeLife(defender.getLife() -a);
            attackerSkillExecute(attacker, defender);
            if (attacker.getLife() <= 0 || defender.getLife() <= 0) {
                break;
            }
            
            // 수비자 턴
            int b = defenderBasicAttack.defendPlainHit(attacker, defender);
            attacker.changeLife(attacker.getLife() -b);
            defenderSkillExecute(attacker, defender);
            System.out.println("공격자 체력" + attacker.getLife());
            System.out.println("수비자 체력" + defender.getLife());
            System.out.println("==================attacker power = " + attacker.getAttackerPower());
            System.out.println("==================defender power = " + defender.getDefensePower());
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
    private boolean attackerAttackUsed = false;
    private boolean attackerDefensiveTypeUsed = false;
    private boolean attackerUtilityTypeUsed = false;

    private boolean defenderAttackUsed = false;
    private boolean defenderDefensiveTypeUsed = false;
    private boolean defenderUtilityTypeUsed = false;

    private void attackerSkillExecute(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();

        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!attackerAttackUsed) {
                if (attacker.getAttackerAttackTypeSkill() != null) {
                    int skillDamage = attacker.getAttackerAttackTypeSkill().execute(attacker, defender);
                    defender.changeLife(defender.getLife() - skillDamage);
                    attackerAttackUsed = true;
                    System.out.println("=====공격자 공격형 스킬");
                    System.out.println(attacker.getAttackerAttackTypeSkill());
                } else {
                    int a = attackerBasicAttack.attackPlainHit(attacker, defender);
                    defender.changeLife(defender.getLife() - a);
                }
            }
        } else if (nowSkillType == 1) {
            if (!attackerUtilityTypeUsed) {
                if (attacker.getAttackerUtilityTypeSkill() != null) {
                    int skillDamage = attacker.getAttackerDefensiveTypeSkill().execute(attacker, defender);
                    attacker.changeLife(attacker.getLife() + skillDamage);
                    attacker.getAttackerUtilityTypeSkill().execute(attacker, defender);
                    attackerUtilityTypeUsed = true;
                    System.out.println("=====공격자 유틸형 스킬");
                    System.out.println(attacker.getAttackerUtilityTypeSkill());
                } else {
                    int a = attackerBasicAttack.attackPlainHit(attacker, defender);
                    defender.changeLife(defender.getLife() -a);
                }
            }
        } else if (nowSkillType == 2) {
            if (!attackerDefensiveTypeUsed) {
                if (attacker.getAttackerDefensiveTypeSkill() != null) {
                    attacker.getAttackerDefensiveTypeSkill().execute(attacker, defender);
                    attackerDefensiveTypeUsed = true;
                    System.out.println("=====공격자 방어형 스킬");
                    System.out.println(attacker.getAttackerDefensiveTypeSkill());
                } else {
                    int a = attackerBasicAttack.attackPlainHit(attacker, defender);
                    defender.changeLife(defender.getLife() -a);
                }
            }
        }
    }

    private void defenderSkillExecute(AttackerCharacterDto attacker, DefenderCharacterDto defender) {
        Integer nowSkillType = -1;
        nowSkillType = skillDraw();
//        System.out.println("=====skillType = " + nowSkillType);

        // 1. 스킬 선택
        if (nowSkillType == 0) {
            if (!defenderAttackUsed) {
                if (defender.getDefenderAttackTypeSkill() != null) {
                    defender.getDefenderAttackTypeSkill().execute(attacker, defender);
                    defenderAttackUsed = true;
                    System.out.println("=====수비자 공격형 스킬");
                    System.out.println(attacker.getAttackerAttackTypeSkill());
                } else {
                    int b = defenderBasicAttack.defendPlainHit(attacker, defender);
                    System.out.println(defender.getDefenderAttackTypeSkill());
                    attacker.changeLife(attacker.getLife() -b);
                }
            }
        } else if (nowSkillType == 1) {
            if (!defenderUtilityTypeUsed) {
                if (defender.getDefenderUtilityTypeSkill() != null) {
                    defender.getDefenderUtilityTypeSkill().execute(attacker, defender);
                    defenderUtilityTypeUsed = true;
                    System.out.println("=====수비자 유틸형 스킬");
                    System.out.println(defender.getDefenderUtilityTypeSkill());
                } else {
                    int b = defenderBasicAttack.defendPlainHit(attacker, defender);
                    attacker.changeLife(attacker.getLife() -b);
                }
            }
        } else if (nowSkillType == 2) {
            if (!defenderDefensiveTypeUsed) {
                if (defender.getDefenderDefensiveTypeSkill() != null) {
                    defender.getDefenderDefensiveTypeSkill().execute(attacker, defender);
                    defenderDefensiveTypeUsed = true;
                    System.out.println("=====수비자 수비형 스킬");
                    System.out.println(defender.getDefenderDefensiveTypeSkill());
                } else {
                    int b = defenderBasicAttack.defendPlainHit(attacker, defender);
                    attacker.changeLife(attacker.getLife() -b);;
                }
            }
        }
    }
    public void applyDamage(CharacterDto defender, int damage) {
        defender.changeLife(defender.getLife() - damage);
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;

import java.util.Random;

public class DefensiveTypeDefenderSkillImpl implements DefenderUtilityTypeSkill{

    //  부서진 방패 스킬 확률
    public Boolean isBrokenShieldPercent(){
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  꺽여버린 창 스킬 확률
    public Boolean isBrokenSpearSkillPercent(){
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  다시하기 스킬 확률
    public Boolean isDoItAgainSkillPercent(){
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  공수교대 스킬 확률
    public Boolean isOffenseDefenseShiftSkillPercent(){
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  강약약강 스킬 확률
    public Boolean isStrongAndWeakSkillPercent(){
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  바꿔치기 스킬 확률
    public Boolean isSwapSkillPercent() {
        double probability = 10;
        Random random = new Random(100);
        if (probability > random.nextInt()) {
            return true;
        }
        return false;
    }

    /* 부러진 방패-(지속성)상대방이 방어형 스킬을 사용하지 못하게 합니다. */
    @Override
    public void utilityTypeDefenderBrokenShield(Character attacker, Character defender) {
        // 부러진 방패 스킬(확률 발동)
        if(isBrokenShieldPercent()){
            attacker.blockDependSkill();
        }
    }

    /* 부러진 창-(지속성)상대방이 공격형 스킬을 사용하지 못하게 합니다. */
    @Override
    public void utilityTypeDefenderBrokenSpear(Character attacker, Character defender) {
        // 부러진 창 스킬(확률 발동)
        if(isBrokenSpearSkillPercent()){
            attacker.blockAttackSkill();
        }
    }

    /* 다시하기-(1회성)상대방과 자신의 체력을 100% 회복합니다. */
    @Override
    public void utilityTypeDefenderDoItAgain(Character attacker, Character defender) {
        // 다시하기 스킬 사용(확률 발동)
        if(isDoItAgainSkillPercent()){
            attacker.restoreHP();
            defender.restoreHP();
        }
    }

    /* 공수교대-(지속성)스킬 사용 후부터 공격자는 방어력으로, 수비자는 공격력으로 전투합니다. */
    @Override
    public void utilityTypeDefenderOffenseDefenseShift(Character attacker, Character defender) {
        // 공수교대 사용(확률 발동)
        if(isOffenseDefenseShiftSkillPercent()){
            attacker.exchangeAtkDef();
            defender.exchangeAtkDef();
        }
    }

    /* 강약약강-(지속성)상대방보다 최대 체력이 많다면, 공격력 및 방어력이 10% 증가하고, (최대 체력이 상대방보다 적다면, 공격력 및 방어력이 10% 감소합니다. */
    @Override
    public void utilityTypeDefenderStrongAndWeak(Character attacker, Character defender) {
        // 강약약강 스킬(확률 발동)
        if (isStrongAndWeakSkillPercent()) {
            if (defender.getMaxLife() > attacker.getMaxLife()) {
                defender.changeAtkp((int) (defender.getAttackerPower() * 1.1));
                defender.changeDef((int) (defender.getDefensePower() * 1.1));
            } else {
                defender.changeAtkp((int) (defender.getAttackerPower() * 0.9));
                defender.changeDef((int) (defender.getDefensePower() * 0.9));
            }
        }
    }
    /* 바꿔치기-(1회성)상대방과 자신의 체력을 교체합니다.(교체 후 자신은 현재 체력의 10%의 피해를 받습니다. */
    @Override
    public void utilityTypeDefenderSwap(Character attacker, Character defender) {
        if (isSwapSkillPercent()) {
            int defenderLife = defender.getLife();
            defender.changeLife((int) (attacker.getLife() * 0.9));
            attacker.changeLife(defenderLife);
        }
    }
}
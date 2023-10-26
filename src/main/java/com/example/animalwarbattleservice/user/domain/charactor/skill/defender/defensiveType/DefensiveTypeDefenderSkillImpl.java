package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;

import java.util.Random;

public class DefensiveTypeDefenderSkillImpl implements DefenderDefensiveTypeSkill{

    //  스킬 확률 관리
    public Boolean percentage(Integer pass){
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  녹슨방패 스킬 30%확률
    public Boolean isRustedSwordSkillPercent(){
        double probability = 30;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }
    //  붕대감기 스킬 50%확률
    public Boolean isBandageSkillPercent(){
        double probability = 50;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }


    /* 비상식량-전투시 전체 체력의 20%를 회복 */
    @Override
    public Integer defensiveTypeDefenderEmergencyFood(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isDependSkill()){
            return 0;
        }

        // 수비자 현재 체력 설정
        int defenderLife = defender.getLife();

        // 비상식량 스킬(확률 발동)
        Integer defenderEmergencyFood = defender.getMaxLife() + defenderLife;
        if (percentage(70)){
            defenderEmergencyFood = (int) (0.2 * defender.getMaxLife() + defenderLife);
        }
        return defenderEmergencyFood;
    }

    /* 힐-전투시 잃은 체력의 30%를 회복 */
    @Override
    public Integer defensiveTypeDefenderHeal(Character attacker, Character defender) {
        // 스킬 여부
        if(!defender.isDependSkill()){
            return 0;
        }

        // 비상식량 스킬 발동 설정 및 공격자 현재 잃은 체력, 현재 체력
        int defenderLostLife = defender.getMaxLife() - defender.getLife();
        int defenderLife = defender.getLife();

        // 힐 스킬(확률 발동)
        Integer defenderHealSkill = defenderLostLife + defenderLife;
        if (percentage(65)){
            defenderHealSkill= (int) ((0.3 * defenderLostLife) + defenderLife);
        }
        return defenderHealSkill;
    }

    /* 철통방어-상대 공격을 3회 무효화 */
    @Override
    public void defensiveTypeDefenderIroncladDefense(Character attacker, Character defender) {
        // 스킬 가능 여부
        if (!defender.isDependSkill()) {
            return;
        }

        // 철통방어 스킬(확률 발동)
        if (percentage(50)){
            attacker.getIroncladDefenseSkillCount();
            attacker.blockBasicAttack();
        }
    }

    /* 럭키7-상대 기본공격을 7회 무효화 */
    @Override
    public void defensiveTypeDefenderLuckySeven(Character attacker, Character defender) {
        // 스킬 가능 여부
        if (!defender.isDependSkill()) {
            return;
        }

        // 공격자 현재체력 설정
        int defenderLife = defender.getLife();
        // 럭키 7 스킬 발동
        if ((defenderLife >= defender.getMaxLife() * 0.77) && percentage(7)) {
            attacker.getLuckySevenSkillCount();
            attacker.blockBasicAttack();
        }
    }

    /* 녹슨 방패-스킬을 사용하면, 일반공격, 데미지를 받는 스킬을 받으면, 20% 데미지 감소. */
    @Override
    public Integer defensiveTypeDefenderRustedSword(Character attacker, Character defender) {
        return null;
    }

    /* 붕대감기-잃은체력을 3턴의 나누어 7%씩 상승. (총 21% 체력이 상승) */
    @Override
    public Integer defensiveTypeDefenderBandage(Character attacker, Character defender) {
        return null;
    }
}
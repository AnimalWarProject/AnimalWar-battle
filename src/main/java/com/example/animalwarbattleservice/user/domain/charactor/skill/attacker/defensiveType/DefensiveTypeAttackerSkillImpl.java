package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;

import java.util.Random;

public class DefensiveTypeAttackerSkillImpl implements AttackerDefensiveTypeSkill{

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
    public Integer defensiveTypeAttackerEmergencyFood(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!attacker.isDependSkill()){
            return 0;
        }

        // 공격자 현재 체력 설정
        int attackerLife = attacker.getLife();

        // 비상식량 스킬(확률 발동)
        Integer attackerEmergencyFood = attacker.getMaxLife() + attackerLife;
        if (percentage(70)){
            attackerEmergencyFood = (int) (0.2 * attacker.getMaxLife() + attackerLife);
        }
        return attackerEmergencyFood;
    }

    /* 힐-전투시 잃은 체력의 30%를 회복 */
    @Override
    public Integer defensiveTypeAttackerHeal(Character attacker, Character defender) {
        // 스킬 여부
        if(!attacker.isDependSkill()){
            return 0;
        }

        // 비상식량 스킬 발동 설정 및 공격자 현재 잃은 체력, 현재 체력
        int attackerLostLife = attacker.getMaxLife() - attacker.getLife();
        int attackerLife = attacker.getLife();

        // 힐 스킬(확률 발동)
        Integer attackerHealSkill = attackerLostLife + attackerLife;
        if (percentage(65)){
            attackerHealSkill = (int) ((0.3 * attackerLostLife) + attackerLife);
        }
        return attackerHealSkill;
    }

    /* 철통방어-상대 공격을 3회 무효화 */
    @Override
    public void defensiveTypeAttackerIroncladDefense(Character attacker, Character defender) {
        // 스킬 가능 여부
        if (!attacker.isDependSkill()) {
            return;
        }

        // 철통방어 스킬(확률 발동)
        if (percentage(50)){
            defender.getIroncladDefenseSkillCount();
            defender.blockBasicAttack();
        }
    }

    /* 럭키7-상대 기본공격을 7회 무효화 */
    @Override
    public void defensiveTypeAttackerLuckySeven(Character attacker, Character defender) {
        // 스킬 가능 여부
        if (!attacker.isDependSkill()) {
            return;
        }

        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 럭키 7 스킬 발동
        if ((attackerLife >= attacker.getMaxLife() * 0.77) && percentage(7)) {
            defender.getLuckySevenSkillCount();
            defender.blockBasicAttack();
        }
    }

    /* 녹슨 방패-스킬을 사용하면, 일반공격, 데미지를 받는 스킬을 받으면, 20% 데미지 감소. */
    @Override
    public Integer defensiveTypeAttackerRustedSword(Character attacker, Character defender) {
        return null;
    }

    /* 붕대감기-잃은체력을 3턴의 나누어 7%씩 상승. (총 21% 체력이 상승) */
    @Override
    public Integer defensiveTypeAttackerBandage(Character attacker, Character defender) {
        return null;
    }
}

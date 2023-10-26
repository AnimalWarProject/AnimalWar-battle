package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import java.util.Random;

public class AttackTypeDefenderSkillImpl implements DefenderAttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass){
        double probability = pass;
        Random random = new Random(100);
        if (probability > random.nextInt()){
            return true;
        }
        return false;
    }

    /* 버서커-(1회성)자신의 체력이 20% 이하일 때, 상대에게 입히는 데미지가 3.5배가 됩니다. */
    @Override
    public Integer attackTypeDefenderBerserker(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }
        // 버서커 스킬 조건
        Integer defenderBerserkerDamage = defender.getDefensePower();

        // 수비자 현재체력 및 최대체력 설정
        int defenderLife = defender.getLife();
        int defenderMaxLife = defender.getMaxLife();

        // 버서커 스킬 (확률 발동)
        if ((defenderLife <= defenderMaxLife / 5) && percentage(70)) {
            defenderBerserkerDamage = (int) 3.5 * (defenderBerserkerDamage);
        }
        return defenderBerserkerDamage;
    }

    /* 폭탄투하-(1회성)상대방 현재 체력의 10%에 해당하는 데미지를 입힙니다. */
    @Override
    public Integer attackTypeDefenderBombDrop(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }

        // 폭탄 투하 스킬 설정
        Integer defenderBombDamage = attacker.getLife();
        if (percentage(40)){
            defenderBombDamage = (int) (0.2 * attacker.getLife());
        }
        return defenderBombDamage;
    }

    /* 처형-다음 5회의 공격 이내 상대방이 10%의 체력 아래라면 처형합니다. */
    @Override
    public Integer attackTypeDefenderExecution(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }

        // 처형스킬 설정
        if (percentage(45)){
            defender.getExecutionSkillCount();
        }
        return null;
    }

    /*비장의 한발-(1회성)다음 1회의 공격이 상대방보다 체력이 적다면 5배의 피해를 입힙니다.(자신의 체력이 더 많다면 추가피해는 없습니다.)  */
    @Override
    public Integer attackTypeDefenderHiddenAce(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }
        
        // 공격자 현재체력 설정
        int attackerLife = defender.getLife();
        // 수비자 현재체력 설정
        int defenderLife = defender.getLife();
        // 비장의 한발 스킬 설정
        Integer defebderHiddenAceDamage = defender.getDefensePower();
        if ((defenderLife < attackerLife) && percentage(45)){
            defebderHiddenAceDamage = 5 * (defender.getDefensePower());
        }
        return defebderHiddenAceDamage;
    }

    /* 독약-(1회성)상대방의 최대 체력의 7%에 해당하는 데미지를 입힙니다. */
    @Override
    public Integer attackTypeDefenderPoison(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }

        // 공격자 최대체력 설정
        int attackerMaxLife = attacker.getMaxLife();

        // 독약 스킬 설정
        Integer defenderPoisonDamage = attackerMaxLife;
        if (percentage(70)){
            defenderPoisonDamage = (int) (0.07 * attackerMaxLife);
        }
        return defenderPoisonDamage;
    }

    /* 빨리감기-(1회성) 상대방과 자신의 현재 체력이 30% 감소합니다. */
    @Override
    public Integer attackTypeDefenderSpeedRun(Character attacker, Character defender) {
        // 스킬 가능 여부
        if(!defender.isAttackSkill()){
            return 0;
        }

        // 수비자 현재체력 설정
        int defenderLife = defender.getLife();
        // 공격자 현재체력 설정
        int attackerLife = attacker.getLife();
        // 빨리감기 스킬(확률 발동)
        if (percentage(85)){
            int AttackerSpeedRun = (int) (attackerLife - attackerLife * 0.7);
            int DefenderSpeedRun = (int) (defenderLife - defenderLife * 0.7);
        }
        return null;
    }
}
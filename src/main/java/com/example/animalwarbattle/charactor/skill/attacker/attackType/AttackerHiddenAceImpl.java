package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;
/*  비장의 한발 : 다음 1회의 공격이 상대방보다 체력이 적다면 5배의 피해를 입힙니다.
(자신의 체력이 더 많다면 일반 공격 데미지) */
@AllArgsConstructor
public class AttackerHiddenAceImpl implements AttackerHiddenAceSkill{
    private final CompatibilityChecker compatibilityChecker;

    @Override
    public Integer hiddenAce(Character attacker, Character defender) {
        // 1. 히든 에이스 스킬 발동 조건 및 상성 체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;

        // 1-1. 히든에이스 스킬 공격력 설정
        int hiddenAceDamage = attacker.getAttackerPower();
        if (attacker.getLife() < defender.getLife()) {
            hiddenAceDamage *= 5;
        }

        //상성체크
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            hiddenAceDamage = attacker.getAttackerPower();
        }

        // 2. 스킬 사용
        remainingHealth = defenderLife - hiddenAceDamage;
        defender.setLife(remainingHealth);
        
        // 3.수비자 체력 0이하 승리
        if (defenderLife <= 0){
            System.out.println("공격자 승리 == 공격 성공");
        }
        return remainingHealth;
    }
}

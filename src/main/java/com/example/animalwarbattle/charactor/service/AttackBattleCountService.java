package com.example.animalwarbattle.charactor.service;

import org.springframework.stereotype.Service;

@Service
public class AttackBattleCountService {
    // 전투 횟수
    private int battleCount;

    // 공격 횟수
    private int attackCount;

    // 수비 횟수
    private int defendCount;

    // 전투 횟수를 증가시키는 메서드
    public void incrementBattleCount() {
        battleCount++;
    }

    // 공격 횟수를 증가시키는 메서드
    public void incrementAttackCount() {
        attackCount++;
    }

    // 수비 횟수를 증가시키는 메서드
    public void incrementDefendCount() {
        defendCount++;
    }

    // 전투 횟수를 반환하는 메서드
    public int getBattleCount() {
        return battleCount;
    }

    // 공격 횟수를 반환하는 메서드
    public int getAttackCount() {
        return attackCount;
    }

    // 수비 횟수를 반환하는 메서드
    public int getDefendCount() {
        return defendCount;
    }

    // 전투 및 공격 횟수를 0으로 재설정하는 메서드
    public void resetCounts() {
        battleCount = 0;
        attackCount = 0;
        defendCount = 0;
    }
}

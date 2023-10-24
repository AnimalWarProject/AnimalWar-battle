package com.example.animalwarbattle.charactor.service;

import org.springframework.stereotype.Service;

public interface BattleCountService {
    void incrementUtilCount();
    void incrementAttackCount();
    void incrementDefendCount();
    int getUtilCount();
    int getAttackCount();
    int getDefendCount();
    void resetCounts();
    boolean isWithinExecutionPeriod();
    boolean isWithinBrokenShieldPeriod();
}


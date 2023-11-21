package com.example.animalwarbattleservice.user.domain.charactor.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleLogger {
    private static final Logger logger = Logger.getLogger(BattleLogger.class.getName());

    private List<String> battleLog;

    public BattleLogger(List<String> battleLog) {
        this.battleLog = battleLog;
    }

    public void log(String message) {
        battleLog.add(message);
        logger.log(Level.INFO, message);
    }
}

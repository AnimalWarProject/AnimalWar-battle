package com.example.animalwarbattle.charactor.service;

import com.example.animalwarbattle.charactor.basicAttack.attacker.BasicAttack;
import com.example.animalwarbattle.charactor.basicAttack.defender.BasicDefend;
import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.skill.attacker.attackType.*;
import com.example.animalwarbattle.charactor.skill.defender.attackType.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CombatService {
    private final AttackBattleCountService countService;

    private final BasicAttack basicAttack;
    private final BasicDefend basicDefend;
    // 공격형 스킬
    private final AttackerBerserkerSkill attackerBerserkerSkill;
    private final DefenderBerserkerSkill defenderBerserkerSkill;

    private final AttackerBombDropSkill attackerBombDropSkill;
    private final DefenderBombDropSkill defenderBombDropSkill;

    private final AttackerExecutionSkill attackerExecutionSkill;
    private final DefenderExecutionSkill defenderExecutionSkill;

    private final AttackerHiddenAceSkill attackerHiddenAceSkill;
    private final DefenderHiddenAceSkill defenderHiddenAceSkill;

    private final AttackerPoisonSkill attackerPoisonSkill;
    private final DefenderPoisonSkill defenderPoisonSkill;

    private final AttackerSpeedRunSkill attackerSpeedRunSkill;
    private final DefenderSpeedRunSkill defenderSpeedRunSkill;
    
    // 수비형 스킬
    
    // 유틸형 스킬


    public void useBerserkerSkill(Character attacker, Character defender){
        attackerBerserkerSkill.berserker(attacker, defender);
        defenderBerserkerSkill.berserker(attacker, defender);
        countService.incrementAttackCount();
        countService.incrementDefendCount();
        countService.incrementBattleCount();
    }
}

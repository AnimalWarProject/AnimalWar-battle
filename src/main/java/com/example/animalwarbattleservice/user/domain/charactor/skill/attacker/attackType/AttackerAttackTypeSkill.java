package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerAttackTypeSkill {


    Integer attackTypeAttackerBerserker (Character attacker, Character defender);
    Integer attackTypeAttackerBombDrop (Character attacker, Character defender);
    Integer attackTypeAttackerExecution (Character attacker, Character defender);
    Integer attackTypeAttackerHiddenAce (Character attacker, Character defender);
    Integer attackTypeAttackerPoison (Character attacker, Character defender);
    Integer attackTypeAttackerSpeedRun (Character attacker, Character defender);

}



package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface AttackerDefensiveTypeSkill {

    Integer defensiveTypeAttackerEmergencyFood (Character attacker, Character defender);
    Integer defensiveTypeAttackerHeal (Character attacker, Character defender);
    void defensiveTypeAttackerIroncladDefense (Character attacker, Character defender);
    void defensiveTypeAttackerLuckySeven (Character attacker, Character defender);
    Integer defensiveTypeAttackerRustedSword (Character attacker, Character defender);
    Integer defensiveTypeAttackerBandage (Character attacker, Character defender);

}



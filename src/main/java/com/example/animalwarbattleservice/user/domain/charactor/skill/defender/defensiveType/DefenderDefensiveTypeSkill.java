package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderDefensiveTypeSkill {

    Integer defensiveTypeDefenderEmergencyFood (Character attacker, Character defender);
    Integer defensiveTypeDefenderHeal (Character attacker, Character defender);
    void defensiveTypeDefenderIroncladDefense (Character attacker, Character defender);
    void defensiveTypeDefenderLuckySeven (Character attacker, Character defender);
    Integer defensiveTypeDefenderRustedSword (Character attacker, Character defender);
    Integer defensiveTypeDefenderBandage (Character attacker, Character defender);
}



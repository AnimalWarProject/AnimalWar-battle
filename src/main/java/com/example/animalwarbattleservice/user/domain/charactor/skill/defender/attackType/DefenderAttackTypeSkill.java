package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.Character;
import org.springframework.stereotype.Component;

@Component
public interface DefenderAttackTypeSkill {

    Integer attackTypeDefenderBerserker (Character attacker, Character defender);
    Integer attackTypeDefenderBombDrop (Character attacker, Character defender);
    Integer attackTypeDefenderExecution (Character attacker, Character defender);
    Integer attackTypeDefenderHiddenAce (Character attacker, Character defender);
    Integer attackTypeDefenderPoison (Character attacker, Character defender);
    Integer attackTypeDefenderSpeedRun (Character attacker, Character defender);

}

package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerAttackTypeSkill {


    Integer attackTypeAttackerBerserker (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeAttackerBombDrop (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeAttackerExecution (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeAttackerHiddenAce (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeAttackerPoison (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeAttackerSpeedRun (CharacterDto attacker, CharacterDto defender);

}



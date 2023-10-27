package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerDefensiveTypeSkill {

    Integer execute (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeAttackerEmergencyFood (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeAttackerHeal (CharacterDto attacker, CharacterDto defender);
//    void defensiveTypeAttackerIroncladDefense (CharacterDto attacker, CharacterDto defender);
//    void defensiveTypeAttackerLuckySeven (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeAttackerRustedSword (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeAttackerBandage (CharacterDto attacker, CharacterDto defender);
}



package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefenderDefensiveTypeSkill {

    Integer execute(CharacterDto attacker, CharacterDto defender);

//    Integer defensiveTypeDefenderEmergencyFood (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeDefenderHeal (CharacterDto attacker, CharacterDto defender);
//    void defensiveTypeDefenderIroncladDefense (CharacterDto attacker, CharacterDto defender);
//    void defensiveTypeDefenderLuckySeven (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeDefenderRustedSword (CharacterDto attacker, CharacterDto defender);
//    Integer defensiveTypeDefenderBandage (CharacterDto attacker, CharacterDto defender);
    }



package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.entity.CharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface DefenderAttackTypeSkill {

    Integer attackTypeDefenderBerserker (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeDefenderBombDrop (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeDefenderExecution (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeDefenderHiddenAce (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeDefenderPoison (CharacterDto attacker, CharacterDto defender);
    Integer attackTypeDefenderSpeedRun (CharacterDto attacker, CharacterDto defender);

}

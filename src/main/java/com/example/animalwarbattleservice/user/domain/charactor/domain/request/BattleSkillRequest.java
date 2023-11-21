package com.example.animalwarbattleservice.user.domain.charactor.domain.request;

import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.UtilityTypeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BattleSkillRequest {
    private AttackTypeSkill attackTypeSkill;
    private DefensiveTypeSkill defensiveTypeSkill;
    private UtilityTypeSkill utilityTypeSkill;

}

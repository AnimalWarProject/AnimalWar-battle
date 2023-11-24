package com.example.animalwarbattleservice.user.domain.charactor.request;

import com.example.animalwarbattleservice.user.domain.charactor.skill.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.utilityType.UtilityTypeSkill;
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

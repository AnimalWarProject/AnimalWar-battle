package com.example.animalwarbattleservice.user.domain.charactor.domain.entity;

import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackTypeAttackerSkillImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;


public class AttackerCharacterDto extends CharacterDto{
    private AttackerAttackTypeSkill attackerAttackTypeSkill = "처형";
    private AttackerUtilityTypeSkill attackerUtilityTypeSkill = "힐";
    private AttackerDefensiveTypeSkill attackerDefensiveTypeSkill = "가시갑옷";

}




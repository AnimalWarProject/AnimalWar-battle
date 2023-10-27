package com.example.animalwarbattleservice.user.domain.charactor.domain.dto;

import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveVoidTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AttackerCharacterDto extends CharacterDto{
    private AttackerBasicAttack attackerBasicAttack;
    private AttackerAttackTypeSkill attackerAttackTypeSkill;
    private AttackerDefensiveTypeSkill attackerDefensiveTypeSkill;
    private AttackerDefensiveVoidTypeSkill attackerDefensiveVoidTypeSkill;
    private AttackerUtilityTypeSkill attackerUtilityTypeSkill;
}




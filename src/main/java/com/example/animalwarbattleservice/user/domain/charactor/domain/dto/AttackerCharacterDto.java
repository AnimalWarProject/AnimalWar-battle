package com.example.animalwarbattleservice.user.domain.charactor.domain.dto;

import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerBerserkerImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AttackerCharacterDto extends CharacterDto{
    private AttackerBasicAttack attackerBasicAttack;
    private AttackerAttackTypeSkill attackerAttackTypeSkill;
    private AttackerDefensiveTypeSkill attackerDefensiveTypeSkill;
    private AttackerUtilityTypeSkill attackerUtilityTypeSkill;

    // 공격자 체력 변화
    public void decreaseHealth(int amount) {
        int newHealth = this.getLife() - amount;
        this.changeLife(newHealth);
    }
}




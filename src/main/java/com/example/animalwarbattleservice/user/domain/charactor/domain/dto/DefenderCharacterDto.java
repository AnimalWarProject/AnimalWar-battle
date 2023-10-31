package com.example.animalwarbattleservice.user.domain.charactor.domain.dto;

import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderUtilityTypeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DefenderCharacterDto extends CharacterDto{
    private DefenderBasicAttack defenderBasicAttack;
    private DefenderAttackTypeSkill defenderAttackTypeSkill;
    private DefenderDefensiveTypeSkill defenderDefensiveTypeSkill;
    private DefenderUtilityTypeSkill defenderUtilityTypeSkill;

    // 수비자 체력 변화
    public void decreaseHealth(int amount) {
        int newHealth = this.getLife() - amount;
        this.changeLife(newHealth);
    }
}




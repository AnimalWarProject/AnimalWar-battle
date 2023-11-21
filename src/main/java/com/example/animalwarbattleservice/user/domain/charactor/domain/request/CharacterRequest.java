package com.example.animalwarbattleservice.user.domain.charactor.domain.request;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.UtilityTypeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {
    private CharacterDto attacker;
    private CharacterDto defender;



    public void setAttacker(CharacterDto attacker) {
        this.attacker = attacker;
    }

    public void setDefender(CharacterDto defender) {
        this.defender = defender;
    }

}

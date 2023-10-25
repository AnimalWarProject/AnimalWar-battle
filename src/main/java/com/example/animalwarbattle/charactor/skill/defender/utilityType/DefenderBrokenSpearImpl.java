package com.example.animalwarbattle.charactor.skill.defender.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderBrokenSpearImpl implements DefenderUtilityTypeSkill{
    @Override
    public void UtilityTypeDefenderExecute(Character attacker, Character defender) {


        // 0. 스킬 확률
        double probability = 0.1;
        Random random = new Random();

        if(random.nextDouble()<probability){
            attacker.blockAttack();
        }
    }
}

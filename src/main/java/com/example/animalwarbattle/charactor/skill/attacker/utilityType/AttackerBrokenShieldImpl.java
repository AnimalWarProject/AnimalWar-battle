package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class AttackerBrokenShieldImpl implements AttackerUtilityTypeSkill{
    @Override
    public void utilityTypeAttackerExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double probability = 0.1;
        Random random = new Random();

        if(random.nextDouble()<probability){
//            defender.setDepend(false);
              defender.blockDepend();
        }

    }
}

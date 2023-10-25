package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class AttackerOffenseDefenseShiftImpl implements AttackerUtilityTypeSkill{
    @Override
    public void utilityTypeAttackerExecute(Character attacker, Character defender) {

//        attacker.exchangeATK_DEF();
//        defender.exchangeATK_DEF();


        // 0. 스킬 확률
        double probability = 0.1;
        Random random = new Random();

        if(random.nextDouble()<probability){

            attacker.exchangeATK_DEF();
            defender.exchangeATK_DEF();
        }


    }
}

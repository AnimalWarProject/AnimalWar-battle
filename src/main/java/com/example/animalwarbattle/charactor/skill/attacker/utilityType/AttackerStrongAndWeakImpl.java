package com.example.animalwarbattle.charactor.skill.attacker.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class AttackerStrongAndWeakImpl implements AttackerUtilityTypeSkill{
    @Override
    public void utilityTypeAttackerExecute(Character attacker, Character defender) {

        // 0. 스킬 확률
        double probability = 0.1;
        Random random = new Random();

        if(random.nextDouble()<probability){
            if(attacker.getMaxLife()>defender.getMaxLife()){
                attacker.changeATKP((int) (attacker.getAttackerPower()*1.1));
                attacker.changeDef((int) (attacker.getDefensePower()*1.1));
            }else{
                attacker.changeATKP((int) (attacker.getAttackerPower()*0.9));
                attacker.changeDef((int) (attacker.getDefensePower()*0.9));
            }
        }


    }
}

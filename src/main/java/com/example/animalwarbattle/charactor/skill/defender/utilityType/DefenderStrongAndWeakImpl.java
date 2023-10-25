package com.example.animalwarbattle.charactor.skill.defender.utilityType;

import com.example.animalwarbattle.charactor.domain.entity.Character;

import java.util.Random;

public class DefenderStrongAndWeakImpl implements DefenderUtilityTypeSkill{
    @Override
    public void UtilityTypeDefenderExecute(Character attacker, Character defender) {

        double probability = 0.1;
        Random random = new Random();

        if(random.nextDouble()<probability){
            if(defender.getMaxLife()>attacker.getMaxLife()){
                defender.changeATKP((int) (defender.getAttackerPower()*1.1));
                defender.changeDef((int) (defender.getDefensePower()*1.1));
            }else{
                defender.changeATKP((int) (defender.getAttackerPower()*0.9));
                defender.changeDef((int) (defender.getDefensePower()*0.9));
            }
        }
    }
}

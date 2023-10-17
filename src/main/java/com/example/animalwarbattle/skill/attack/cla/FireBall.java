package com.example.animalwarbattle.skill.attack.cla;

import com.example.animalwarbattle.skill.attack.inter.AttackSkill;
import com.example.animalwarbattle.skill.dto.Character;

public class FireBall implements AttackSkill {

    @Override
    public void decreaseLife(Character target) {
        target.decreaseLife((int) (target.getLife() * 0.9));
    }
}

package com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/*  힐 : 전투시 잃은 체력의 30%를 회복합니다.  */
public class HealImpl implements DefensiveTypeSkill {
    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    /* 힐-전투시 잃은 체력의 30%를 회복 */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 여부
        if(!attacker.isDependSkill()){
            return 1;
        }
            int battleLostLife = attacker.getMaxLife() - attacker.getLife();
            int healAmount = (int) (0.3 * battleLostLife);
        // 힐 스킬(확률 발동)
        if (percentage(99)) {
            attacker.changeLife(attacker.getLife() + healAmount);
        }
        return attacker.getLife();
    }
}
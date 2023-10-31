package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;

import java.util.Random;

public class AttackerBombDropImpl implements AttackerAttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    /* 폭탄투하-(1회성)상대방 현재 체력의 10%에 해당하는 데미지를 입힙니다. */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if (!attacker.isAttackSkill()) {
            return 0;
        }

        // 폭탄 투하 스킬 설정
        Integer attackerBombDamage = defender.getLife();
        if (percentage(40)) {
            attackerBombDamage = (int) (0.2 * defender.getLife());
        }
        return attackerBombDamage;
    }
}
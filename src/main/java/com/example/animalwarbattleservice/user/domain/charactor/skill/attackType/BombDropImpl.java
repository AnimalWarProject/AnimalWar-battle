package com.example.animalwarbattleservice.user.domain.charactor.skill.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/* 폭탄투하-(1회성)상대방 현재 체력의 20%에 해당하는 데미지를 입힙니다. */
public class BombDropImpl implements AttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {
        // 스킬 가능 여부
        if (!attacker.isAttackSkill()) {
            return 0;
        }

        // 폭탄 투하 스킬 설정
        Integer bombDropDamage = defender.getLife();
        if (percentage(45)) {
            bombDropDamage = (int) (0.2 * defender.getLife());
        }
        return bombDropDamage;
    }
}
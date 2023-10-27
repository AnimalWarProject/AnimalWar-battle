package com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType;//package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;

    /* 폭탄투하-(1회성)상대방 현재 체력의 10%에 해당하는 데미지를 입힙니다. */
public class DefenderBombDropImpl implements DefenderAttackTypeSkill {

        //  스킬 확률 관리
        public Boolean percentage(Integer pass) {
            double probability = pass;
            Random random = new Random(100);
            if (probability > random.nextInt()) {
                return true;
            }
            return false;
        }

        @Override
        public Integer execute(CharacterDto attacker, CharacterDto defender) {
            // 스킬 가능 여부
            if (!defender.isAttackSkill()) {
                return 0;
            }

            // 폭탄 투하 스킬 설정
            Integer defenderBombDamage = attacker.getLife();
            if (percentage(40)) {
                defenderBombDamage = (int) (0.2 * attacker.getLife());
            }
            return defenderBombDamage;
        }
    }

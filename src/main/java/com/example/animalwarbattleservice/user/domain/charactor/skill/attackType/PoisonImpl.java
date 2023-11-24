package com.example.animalwarbattleservice.user.domain.charactor.skill.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
public class PoisonImpl implements AttackTypeSkill {
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
    if(!attacker.isAttackSkill()){
        return 0;
    }

    // 수비자 최대체력 설정
    int defenderMaxLife = defender.getMaxLife();

    // 독약 스킬 설정
    Integer poisonDamage = defenderMaxLife;
    if (percentage(99)){
        poisonDamage = (int) (0.07 * defenderMaxLife);
    }
    return poisonDamage;
    }
}
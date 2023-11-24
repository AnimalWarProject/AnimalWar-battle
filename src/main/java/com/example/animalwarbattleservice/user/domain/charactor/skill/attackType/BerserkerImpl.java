package com.example.animalwarbattleservice.user.domain.charactor.skill.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import java.util.Random;

/*  버서커 : 자신의 체력이 20%이하 남았을 때, 스킬이 발동이 되며, 상대에게 입히는 데미지가 3배.  */
public class BerserkerImpl implements AttackTypeSkill {

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
        if (percentage(100)){
            attacker.setBerserkerActivated(true);
        }
        return 0;
    }
}
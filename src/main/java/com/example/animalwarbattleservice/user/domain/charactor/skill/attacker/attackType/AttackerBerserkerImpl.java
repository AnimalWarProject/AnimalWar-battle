package com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;


///*  버서커 : 자신의 체력이 20%이하 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import org.springframework.stereotype.Component;
import java.util.Random;

public class AttackerBerserkerImpl implements AttackerAttackTypeSkill {

    //  스킬 확률 관리
    public Boolean percentage(Integer pass) {
        double probability = pass;
        Random random = new Random();
        if (probability > random.nextInt(100)) {
            return true;
        }
        return false;
    }

    /* 버서커-(1회성)자신의 체력이 20% 이하일 때, 상대에게 입히는 데미지가 3.5배가 됩니다. */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {

        // 스킬 가능 여부
        if (!attacker.isAttackSkill()) {
            return 0;
        }

        // 버서커 스킬 조건
        Integer attackerberserkerDamage = attacker.getAttackerPower();
        // 공격자 현재체력 및 최대체력 설정
        int attackerLife = attacker.getLife();
        int attackerMaxLife = attacker.getMaxLife();

        // 버서커 스킬 (확률 발동)
        if ((attackerLife <= attackerMaxLife / 5) && percentage(70)) {
            attackerberserkerDamage = (int) 3.5 * (attackerberserkerDamage);
        }
        return attackerberserkerDamage;
    }
}
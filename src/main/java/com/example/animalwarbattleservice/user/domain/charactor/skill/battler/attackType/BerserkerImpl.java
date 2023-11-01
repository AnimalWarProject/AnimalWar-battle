package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType;//package com.example.animalwarbattle.charactor.skill.attacker.attackType;


/*  버서커 : 자신의 체력이 20%이하 남았을 때, 스킬이 발동이 되며, 상대에게 입히는 데미지가 2배가 지속적으로 쌔집니다.  */
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import java.util.Random;

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

    /* 버서커-(지속성)자신의 체력이 20% 이하일 때, 상대에게 입히는 데미지가 3.5배가 됩니다. */
    @Override
    public Integer execute(CharacterDto attacker, CharacterDto defender) {

        // 스킬 가능 여부
        if (!attacker.isAttackSkill()) {
            return 1;
        }

        // 버서커 스킬 조건
        Integer berserkerDamage = 3 * attacker.getBattlePower();
        // 공격자 현재체력 및 최대체력 설정
        int attackerLife = attacker.getLife();
        int attackerMaxLife = attacker.getMaxLife();
        if (percentage(99)) {
            if (attackerLife <= attackerMaxLife / 5) {
                attacker.changeBattlePower(berserkerDamage);
            }
        }
        // 체력이 20% 이하로 떨어질 경우 버서커 스킬 활성화
//        if ((double)attackerLife / attackerMaxLife <= 0.2) {
//            attacker.setBerserkerActivated(true);
//        }

        // 버서커 스킬 (확률 발동)
//        if (attacker.isBerserkerActivated() && percentage(99)) {
//            berserkerDamage = 3 * berserkerDamage;
//            attacker.changeBattlePower(berserkerDamage);
//        }
        return berserkerDamage;
    }
}


// if (attacker.getMaxLife() > defender.getMaxLife()) {
//         attacker.changeBattlePower((int) (attacker.getBattlePower() * 1.1));
//         attacker.changeBattlePower((int) (attacker.getBattlePower() * 1.1));
//         } else {
//         attacker.changeBattlePower((int) (attacker.getBattlePower() * 0.9));
//         attacker.changeBattlePower((int) (attacker.getBattlePower() * 0.9));
//         }
package com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType;//package com.example.animalwarbattle.charactor.skill.attacker.defensiveType;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;

import java.util.Random;


///*  비상식량 : 전투시 전체 체력의 20%를 회복합니다. */
public class EmergencyFoodImpl implements DefensiveTypeSkill {

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
        if (!attacker.isDependSkill()) {
            return 1;
        }

        // 공격자 현재 체력 설정
        int battleLife = attacker.getLife();

        // 비상식량 스킬(확률 발동)
        Integer attackerEmergencyFood = attacker.getMaxLife() + battleLife;
        if (percentage(99)) {
            attackerEmergencyFood = (int) (0.2 * attacker.getMaxLife() + battleLife);
        }
        return attackerEmergencyFood;
    }
}




// public class CharacterDto { ... private boolean berserkerActivated = false;
// public boolean isBerserkerActivated() { return berserkerActivated; }
// public void setBerserkerActivated(boolean berserkerActivated) {
// this.berserkerActivated = berserkerActivated; } ... }






//    @Override public Integer execute(CharacterDto attacker, CharacterDto defender) {
    // 스킬 가능 여부 if (!attacker.isAttackSkill()) { return 1; }
// 버서커 스킬 조건 Integer berserkerDamage = attacker.getBattlePower();
        // 공격자 현재체력 및 최대체력 설정 int attackerLife = attacker.getLife(); int attackerMaxLife = attacker.getMaxLife();
        // 체력이 20% 이하로 떨어질 경우 버서커 스킬 활성화 if ((double)attackerLife / attackerMaxLife <= 0.2) { attacker.setBerserkerActivated(true); }
        // 버서커 스킬 (확률 발동) if (attacker.isBerserkerActivated() && percentage(99)) { berserkerDamage = 3 * berserkerDamage; } return berserkerDamage; }
//    }
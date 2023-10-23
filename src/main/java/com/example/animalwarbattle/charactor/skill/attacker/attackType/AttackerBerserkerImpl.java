package com.example.animalwarbattle.charactor.skill.attacker.attackType;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
@AllArgsConstructor
public class AttackerBerserkerImpl implements AttackerBerserkerSkill {
    private final CompatibilityChecker compatibilityChecker;

    @Override
    public Integer berserker(Character attacker, Character defender) {
        // 1. 버서커 스킬 발동 조건 및 상성 체크
        boolean hasCompatibility = compatibilityChecker.check(attacker, defender);
        // 수비자 체력 설정
        int defenderLife = defender.getLife();
        int remainingHealth;

        // 1-1. 버서커 스킬 발동 조건 및 공격력 설정
        int berserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            berserkerDamage *= 2;
        }
        // 상성체크
        if (hasCompatibility) {
            compatibilityChecker.increaseAttackerCombatPower(attacker);
            berserkerDamage = attacker.getAttackerPower();
        }
        
        // 2. 스킬 사용
        remainingHealth = defenderLife - berserkerDamage;
        defender.setLife(remainingHealth);

        // 3. 수비자 체력 0이하 승리
        if (defenderLife <= 0) {
            System.out.println("공격자 승리 == 공경 성공");
        }
        return remainingHealth;
    }
}



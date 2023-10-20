package com.example.animalwarbattle.charactor.skill.attacker.attack;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
@AllArgsConstructor
public class AttackerBerserkerImpl implements AttackerBerserkerSkill {
    private final CompatibilityChecker checker;

    @Override
    public Integer berserker(Character attacker, Character defender) {
//      버서커 스킬 발동 조건 및 상성 체크하기
//      1-1. CompatibilityChecker 클래스를 어떻게 거치게 하나? 상성 관계이면, 전투력이 오른 상태에서 시작하게 하려면?
//      1-2. 버서커 공격력(공격자) 설정




        // 버서커 스킬 발동 조건 및 공격력 설정
        Integer berserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            berserkerDamage = berserkerDamage * 2;
        }

        // 버서커 스킬 사용
        // 2-1. 버서커 스킬은 딱 한 번 만 쓸 수 있다.

        // 2-2. 버서커 스킬 사용 및 체력 확인
        Integer defenderLife = defender.getLife();
        defenderLife = defender.getLife() - berserkerDamage;
        defender.setLife(defenderLife);

        // 3. 상태확인
        if (defenderLife <= 0) {
            System.out.println("사망===전투 종료");
        } else {
            attacker.getLife();
        }
        return defenderLife;
    }
}
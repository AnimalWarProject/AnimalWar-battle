package com.example.animalwarbattle.charactor.skill.attacker.attack.cla;


import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.skill.attacker.attack.inter.AttackerBerserkerSkill;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.  */
@AllArgsConstructor
public class AttackerBerserkerImpl implements AttackerBerserkerSkill {
    private final CompatibilityChecker checker;

    @Override
    public Integer berserker(Character attacker, Character defender) {
//      버서커 스킬 만들기
//      1-1. 상성 체크를 해주고. 상성 관계이면, 전투력이 오른 상태에서 시작
//      1-2. 현재 턴 공격력(공격자) 설정


        Integer berserkerDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()) {
            berserkerDamage = berserkerDamage * 2;
        }

//      버서커 스킬 사용
//      2-1. 버서커 스킬은 딱 한 번 만 쓸 수 있다.
//      2-2.
        Integer defenderLife = defender.getLife();
        defenderLife = defender.getLife() - berserkerDamage;
        defender.setLife(defenderLife);
//      3. 상태확인
        if (defenderLife <= 0) {
            System.out.println("사망===전투 종료");
        } else {
            attacker.getLife();
        }
        return defenderLife;
    }
}

/*
public Integer getAttackPower(Character attacker,Character defender){
	Integer initial_power = attacker.getAttackPower()
	String skill = attacker.getSkill()
	if (skil == 버서커){initial_power = 공격버서커(initial_power)}
	if check(attacker, defender) {initial_power  = initial_power  * 2}
	return initial_power
}

public match(Character attacker,Character defender){
	Integer attackerPower = getAttackPower(attacker, defender)
	Integer defenderPower = getDeffencePower(attacker, defender)
	attacker.setLife(attacker.getLife() - defenderPower)
	defender.setLife(defender.getLife() - attackerPower)
	dieCheck(attacker, defender)
}
public Integer dieCheck(Character attacker,Character defender){
	if (attacker.getlife()  <= 0 && defender.getlife() <= 0 ){ return 3}
	if (attacker.getlife() <= 0){return 1}
	if (defender.getlife() <= 0){return 2}
	return 0
}


 */
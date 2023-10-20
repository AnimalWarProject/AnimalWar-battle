package com.example.animalwarbattle.skill.attacker.attack.cla;


import com.example.animalwarbattle.skill.attacker.attack.inter.BerserkerSkill;
import com.example.animalwarbattle.domain.entity.Character;

public class AttackerBerserker implements BerserkerSkill {

    @Override
    public Integer berserker(Character attacker, Character defender) {

//      0. 상성 파악을 하고 상대에 대한 상성이면, 공격력 10% 증가
//      if 상성(attacker, defender) {attackDamage = attackDamgage * 1.2}
//      if attacker.getCompatibility(attacker, defender) {attackDamage = attackDamgage * 1.2}
//

//      1-1. 현재 턴 공격력(공격자) 설정
        Integer attackDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()){
            attackDamage = attackDamage *2;
        }


//      3. 때리기
        Integer defenderLife = defender.getLife();
        defenderLife = defender.getLife() - attackDamage;
        defender.setLife(defenderLife);

//      4. 상태확인
        if (defenderLife <= 0) {
            System.out.println("사망===전투 종료");
        }else {
            attacker.getLife();
        }
        return attackDamage;
/*        버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.




 */




    }

    public Integer getBerserker (Character attacker, Character defender){
        Integer initialPower = attacker.getAttackerPower();
        String skill = attacker.getSkill();
        if (skill == berserker() ) {
            initialPower =
        }
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
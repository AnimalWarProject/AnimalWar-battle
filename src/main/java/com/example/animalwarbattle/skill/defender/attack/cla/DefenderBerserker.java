package com.example.animalwarbattle.skill.defender.attack.cla;


import com.example.animalwarbattle.skill.attacker.attack.inter.BerserkerSkill;
import com.example.animalwarbattle.domain.entity.Character;

public class DefenderBerserker implements BerserkerSkill {

    @Override
    public Integer berserker(Character attacker, Character defender) {
//

//      1-1. 현재 턴 공격력(공격자) 설정
        Integer attackDamage = attacker.getAttackerPower();
        if (attacker.getMaxLife() / 5 >= attacker.getLife()){
            attackDamage = attackDamage *2;
        }
//      1-2. 현재 턴 수비력(수비자) 설정
        Integer defenderDamage = defender.getDefensePower();
        if (defender.getMaxLife() / 5 >= defender.getLife()){
            defenderDamage = defenderDamage *2;
        }
//      2. 상성
//      if 상성(attacker, defender) {attackDamage = attackDamgage * 1.2}
//      if attacker.getCompatibility(attacker, defender) {attackDamage = attackDamgage * 1.2}
// 어택은 어택파워 리턴
        // 디펜스

//      3. 때리기
        Integer defenderLife = defender.getLife();
        defenderLife = defender.getLife() - attackDamage;
        defender.setLife(defenderLife);

        Integer attackerLife = attacker.getLife();
        attackerLife = attacker.getLife() - defenderDamage;
        attacker.setLife(attackerLife);
//      attacker.setLife(attacker.getLife() - defenderDamage);

//      1. 현재 턴 공격력 설정
//      attackDamage = 공격자 공격력
//      만약 (공격자 체력이 20% 이하이면){
//      공격자에 데미지가 2배가 된다.

//      3. 떄리기
//      defenderLife = 수비자 체력
//      수비자 체력 = 수비자 체력 - 2배 공격자 데미지
//      수비자 체력을 수비자 체력에게 보낸다
//
//      attackerLife = 공격자 체력
//      만약 공격자 공격력이 2

//      4. 상태확인
        if (attackerLife <= 0) {
            System.out.println("사망===전투 종료");
        }else {
            attacker.getLife();
        }
//      스킬을 사용하고 나면, 상대 체력 확인, 만약 0 이하면 사망으로 처리, 0 이상이면 체력 점수 나타내 주기
//
//
//
//

//
/*        버서커 : 자신의 체력이 20% 남았을 때 상대에게 입히는 데미지가 2배가 됩니다.
        public Integer getDeffencePower(Character attacker,Character defender){
            Integer initial_power = defender.getDefencePower()
            String skill = attacker.getSkill()
            if (skil == 버서커){initial_power = 수비버서커(initial_power)}
            if check(deffendor, attacker) {initial_power  = initial_power  * 2}
            return initial_power
        }
*/


        return attackDamage;
    }
}



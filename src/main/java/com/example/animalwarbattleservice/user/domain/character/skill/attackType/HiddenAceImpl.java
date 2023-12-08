package com.example.animalwarbattleservice.user.domain.character.skill.attackType;
import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/*  비장의 한발-(1회성)다음 1회의 공격이 상대방보다 체력이 적다면 5배의 피해를 입힙니다.
(자신의 체력이 더 많다면 추가피해는 없습니다.)  */
public class HiddenAceImpl implements AttackTypeSkill {
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

        int attackerLife = attacker.getLife();
        int defenderLife = defender.getLife();
        Integer hiddenAceDamage = attacker.getAttackPower();
        if ((attackerLife < defenderLife) && percentage(65)) {
            hiddenAceDamage *= 5 ;
        } else {
            hiddenAceDamage = -1;
        }
        return hiddenAceDamage;
    }
}
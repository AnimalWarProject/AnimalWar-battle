package com.example.animalwarbattleservice.user.domain.character.skill.defensiveType;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import java.util.Random;

/* 붕대감기: 잃은체력의 3턴의 나누어 7%씩 총 21% 체력이 올라갑니다. */
public class BandagingImpl implements DefensiveTypeSkill{

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
        // 스킬 여부
        if(!attacker.isDependSkill()){
            return 1;
        }

        Integer attackerLife = 0;
        if (percentage(75)) {
            if (attacker.getBandagingSkillCount() > 0){
                attacker.changeBanding(3);
            }
        } 
        else {
            attackerLife = -1;
        }
        return attackerLife;
    }
}
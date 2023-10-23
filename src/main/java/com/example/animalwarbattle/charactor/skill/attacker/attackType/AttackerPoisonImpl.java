package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;
/*  독약 : 상대방의 최대 체력의 5%에 해당하는 데미지를 입힙니다 */
@AllArgsConstructor
public class AttackerPoisonImpl implements AttackerPoisonSkill {

    @Override
    public Integer poison(Character attacker, Character defender) {
        return null;
    }
}

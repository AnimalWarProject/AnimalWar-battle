package com.example.animalwarbattle.domain.entity;

import com.example.animalwarbattle.compatibility.domain.entity.CompatibilityEnum;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder @Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {
    private UUID userUUID;
    private String nickName;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;
    private CompatibilityEnum compatibility;
    private String skill;


    // 누가 상성을 가지고 있는지 확인
    public int getCombatPower(boolean isAttacker) {
        if (isAttacker) {
            return this.attackerPower;
        } else {
            return this.defensePower;
        }
    }
}
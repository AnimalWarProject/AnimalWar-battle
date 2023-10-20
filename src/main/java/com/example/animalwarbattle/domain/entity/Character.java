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


    // 누가 상성을 가지고 있는지 확인하는 메서드
    public int getCombatPower(boolean isAttacker) {
        if (isAttacker) {
            return this.attackerPower;
        } else {
            return this.defensePower;
        }
    }

    // 공격자나 수비자의 전투력을 설정하는 메서드
    public void setCombatPower(boolean isAttacker, int power){
        if (isAttacker) {
            this.attackerPower = power;
        }else {
            this.defensePower = power;
        }
    }
}
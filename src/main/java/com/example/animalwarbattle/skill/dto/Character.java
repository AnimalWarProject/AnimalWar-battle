package com.example.animalwarbattle.skill.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {
    private UUID userUUID;
    private String nickName;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;

    public void decreaseLife(int amount) {
        this.life -= amount;
    }
}

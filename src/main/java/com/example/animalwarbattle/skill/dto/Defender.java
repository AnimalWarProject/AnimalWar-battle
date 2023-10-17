package com.example.animalwarbattle.skill.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Defender {
    private UUID userUUID;
    private String nickName;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;
}

package com.example.animalwarbattle.charactor.domain.entity;

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
    private int attackCount = 0;
    private int defendCount = 0;

}


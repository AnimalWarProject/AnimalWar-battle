package com.example.animalwarbattle.charactor.domain.entity;

import com.example.animalwarbattle.compatibility.domain.CompatibilityEnum;

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
    private String skill;
    private CompatibilityEnum compatibility;
    private int attackSkillCount = 0;
    private int defendSkillCount = 0;
    private int utilSkillCount = 0;

}


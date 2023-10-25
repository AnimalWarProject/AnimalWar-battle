package com.example.animalwarbattle.charactor.domain.entity;

import com.example.animalwarbattle.compatibility.domain.CompatibilityEnum;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder @Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userUUID;

    public String userId;
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


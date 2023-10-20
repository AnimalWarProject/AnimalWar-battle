package com.example.animalwarbattle.charactor.domain.dto;

import com.example.animalwarbattle.compatibility.domain.entity.CompatibilityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Builder @Getter
public class MyCharacter {
    private UUID userUUID;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;
    private CompatibilityEnum compatibility;
}

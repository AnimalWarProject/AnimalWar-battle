package com.example.animalwarbattleservice.user.domain.charactor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;


@RequiredArgsConstructor
@Getter
@ToString
public class UserUpdateByGameResultDto {
    private final UUID attackerId;
    private final int gold;
    private final int battlePoint;
}

package com.example.animalwarbattleservice.user.domain.character.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@Setter
public class StateDto {
    private boolean attackerAttackUsed;
    private boolean attackerDefensiveTypeUsed;
    private boolean attackerUtilityTypeUsed;
    private boolean defenderAttackUsed;
    private boolean defenderDefensiveTypeUsed;
    private boolean defenderUtilityTypeUsed;
}

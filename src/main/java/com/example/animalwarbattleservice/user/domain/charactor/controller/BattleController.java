package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.EmergencyFoodImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BattleController {
    private BattleService battleService;


    @PostMapping
    public void battleCheck(){
        CharacterDto attackerCharacterDto = new CharacterDto();
        attackerCharacterDto.setNickName("군산 불도저 이세인");
        attackerCharacterDto.setAttackTypeSkill(new BerserkerImpl());
        attackerCharacterDto.setDefenseTypeSkill(new EmergencyFoodImpl());
        attackerCharacterDto.setUtilityTypeSkill(new OffenseDefenseShiftImpl());
        attackerCharacterDto.changeLife(10000);
        attackerCharacterDto.changeMaxLife(10000);
        attackerCharacterDto.changeBattlePower(500);
        attackerCharacterDto.changeDefendPower(700);
        attackerCharacterDto.setCompatibility(CompatibilityEnum.DOG);

        CharacterDto defenderCharacterDto = new CharacterDto();
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.setAttackTypeSkill(new BerserkerImpl());
        defenderCharacterDto.setDefenseTypeSkill(new EmergencyFoodImpl());
        defenderCharacterDto.setUtilityTypeSkill(new OffenseDefenseShiftImpl());
        defenderCharacterDto.changeLife(10000);
        defenderCharacterDto.changeMaxLife(10000);
        defenderCharacterDto.changeBattlePower(100);
        defenderCharacterDto.changeDefendPower(1000);
        defenderCharacterDto.setCompatibility(CompatibilityEnum.DOG);
        battleService.conductBattle(attackerCharacterDto, defenderCharacterDto);
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BattleController {
    private BattleService battleService;


    @PostMapping
    public void battleCheck(
//        @RequestBody CharacterDto attacker
    ){
//        CharacterDto deffencer = charaterService.findByDefenderId(defenderId);

        CharacterDto attackerCharacterDto = new CharacterDto();
        attackerCharacterDto.setNickName("군산 불도저 이세인");
        attackerCharacterDto.setAttackTypeSkill(new BombDropImpl());
        attackerCharacterDto.setDefenseTypeSkill(new BandagingImpl());
        attackerCharacterDto.setUtilityTypeSkill(new StrongAndWeakImpl());
        attackerCharacterDto.changeLife(10000);
        attackerCharacterDto.changeMaxLife(10000);
        attackerCharacterDto.changeBattlePower(444);
        attackerCharacterDto.changeDefendPower(777);
        attackerCharacterDto.setCompatibility(CompatibilityEnum.BIRD);

        CharacterDto defenderCharacterDto = new CharacterDto();
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.setAttackTypeSkill(new PoisonImpl());
        defenderCharacterDto.setDefenseTypeSkill(new LuckySevenImpl());
        defenderCharacterDto.setUtilityTypeSkill(new DoItAgainImpl());
        defenderCharacterDto.changeLife(10000);
        defenderCharacterDto.changeMaxLife(10000);
        defenderCharacterDto.changeBattlePower(444);
        defenderCharacterDto.changeDefendPower(777);
        defenderCharacterDto.setCompatibility(CompatibilityEnum.CAT);
        battleService.conductBattle(attackerCharacterDto, defenderCharacterDto);
    }
}
package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.BerserkerImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.LuckySevenImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.DoItAgainImpl;
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
        attackerCharacterDto.setDefenseTypeSkill(new LuckySevenImpl());
        attackerCharacterDto.setUtilityTypeSkill(new DoItAgainImpl());
        attackerCharacterDto.changeBattlePower(480);
        attackerCharacterDto.setCompatibility(CompatibilityEnum.DOG);

        CharacterDto defenderCharacterDto = new CharacterDto();
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.setAttackTypeSkill(new BerserkerImpl());
        defenderCharacterDto.setDefenseTypeSkill(new LuckySevenImpl());
        defenderCharacterDto.setUtilityTypeSkill(new DoItAgainImpl());
        defenderCharacterDto.changeBattlePower(450);
        defenderCharacterDto.setCompatibility(CompatibilityEnum.BIRD);

        battleService.conductBattle(attackerCharacterDto, defenderCharacterDto);
    }
}
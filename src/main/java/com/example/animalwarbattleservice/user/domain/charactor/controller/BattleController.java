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
        CharacterDto attackerCharacterDto = new CharacterDto();
        attackerCharacterDto.setNickName("군산 불도저 이세인");
        attackerCharacterDto.setAttackTypeSkill(new SpeedRunImpl());
        attackerCharacterDto.setDefenseTypeSkill(new RustedSwordImpl());
        attackerCharacterDto.setUtilityTypeSkill(new StrongAndWeakImpl());
        attackerCharacterDto.changeLife(20000);
        attackerCharacterDto.changeMaxLife(20000);
        attackerCharacterDto.changeBattlePower(111);
        attackerCharacterDto.changeDefendPower(222);
        attackerCharacterDto.setCompatibility(CompatibilityEnum.CAT);

        CharacterDto defenderCharacterDto = new CharacterDto();
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.setAttackTypeSkill(new SpeedRunImpl());
        defenderCharacterDto.setDefenseTypeSkill(new RustedSwordImpl());
        defenderCharacterDto.setUtilityTypeSkill(new StrongAndWeakImpl());
        defenderCharacterDto.changeLife(10000);
        defenderCharacterDto.changeMaxLife(10000);
        defenderCharacterDto.changeBattlePower(111);
        defenderCharacterDto.changeDefendPower(222);
        defenderCharacterDto.setCompatibility(CompatibilityEnum.CAT);
        battleService.conductBattle(attackerCharacterDto, defenderCharacterDto);
    }
}
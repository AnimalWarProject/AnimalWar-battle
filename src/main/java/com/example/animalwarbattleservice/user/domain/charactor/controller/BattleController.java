package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker.AttackerBasicAttackImpl;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.defender.DefenderBasicAttackImpl;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.AttackerCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.DefenderCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.service.CombatService;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerBerserkerImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerEmergencyFoodImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerLuckySevenImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerBrokenShieldImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.attackType.DefenderBerserkerImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderEmergencyFoodImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderHealImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.defensiveType.DefenderIroncladDefenseImpl;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defender.utilityType.DefenderSwapImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BattleController {
    private CombatService combatService;


    @PostMapping
    public void battleCheck(){
        AttackerCharacterDto attackerCharacterDto = new AttackerCharacterDto(
                new AttackerBasicAttackImpl(),
                new AttackerBerserkerImpl(),
                new AttackerLuckySevenImpl(),
                new AttackerEmergencyFoodImpl(),
                new AttackerBrokenShieldImpl());
        attackerCharacterDto.setNickName("군산 불도저 이세인");
        attackerCharacterDto.getLife();
        attackerCharacterDto.changeMaxLife(100000);
        attackerCharacterDto.setAttackerPower(500);
        attackerCharacterDto.setCompatibility(CompatibilityEnum.BIRD);

        DefenderCharacterDto defenderCharacterDto = new DefenderCharacterDto(
                new DefenderBasicAttackImpl(),
                new DefenderBerserkerImpl(),
                new DefenderEmergencyFoodImpl(),
                new DefenderIroncladDefenseImpl(),
                new DefenderSwapImpl());
        defenderCharacterDto.setNickName("포항 상남자 김정수");
        defenderCharacterDto.getLife();
        defenderCharacterDto.changeMaxLife(100000);
        defenderCharacterDto.setDefensePower(500);
        defenderCharacterDto.setCompatibility(CompatibilityEnum.DOG);

        combatService.conductBattle(attackerCharacterDto, defenderCharacterDto);
    }
}

package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.request.CharacterRequest;
import com.example.animalwarbattleservice.user.domain.charactor.service.BattleService;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.*;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/battle")
public class BattleController {
    private BattleService battleService;

    private static final HashMap<String,AttackTypeSkill>
            hangleToAttackTypeSkill = new HashMap<>();

    private static final HashMap<String,DefensiveTypeSkill>
            hangleToDefensiveTypeSkill = new HashMap<>();

    private static final HashMap<String,UtilityTypeSkill>
            hangleToUtilityTypeSkill = new HashMap<>();


    @PostMapping
    public List<String> battleCheck(@RequestBody CharacterRequest request) {
        CharacterDto attacker = request.getAttacker();
        CharacterDto defender = request.getDefender();

        hangleToAttackTypeSkill.put("버서커", new BerserkerImpl());
        hangleToAttackTypeSkill.put("폭탄 투하", new BombDropImpl());
        hangleToAttackTypeSkill.put("처형", new ExecutionImpl());
        hangleToAttackTypeSkill.put("비장의 한발", new HiddenAceImpl());
        hangleToAttackTypeSkill.put("독약", new PoisonImpl());
        hangleToAttackTypeSkill.put("빨리감기", new SpeedRunImpl());

        hangleToDefensiveTypeSkill.put("비상식령" ,new EmergencyFoodImpl());
        hangleToDefensiveTypeSkill.put("회복" ,new HealImpl());
        hangleToDefensiveTypeSkill.put("철통방어" ,new IroncladDefenseImpl());
        hangleToDefensiveTypeSkill.put("럭기 7" ,new LuckySevenImpl());
        hangleToDefensiveTypeSkill.put("녹슨 방패" ,new RustedSwordImpl());
        hangleToDefensiveTypeSkill.put("붕대 감기" ,new BandagingImpl());

        hangleToUtilityTypeSkill.put("부러진 창" ,new BrokenSpearImpl());
        hangleToUtilityTypeSkill.put("부러진 방패" ,new BrokenShieldImpl());
        hangleToUtilityTypeSkill.put("다시하기" ,new DoItAgainImpl());
        hangleToUtilityTypeSkill.put("공수교대" ,new OffenseDefenseShiftImpl());
        hangleToUtilityTypeSkill.put("강약약강" ,new StrongAndWeakImpl());
        hangleToUtilityTypeSkill.put("바꿔치기" ,new SwapImpl());


        attacker.setCompatibility(CompatibilityEnum.valueOf(attacker.getSpecies()));
        defender.setCompatibility(CompatibilityEnum.valueOf(defender.getSpecies()));

        attacker.setAttackTypeSkill(hangleToAttackTypeSkill.get(attacker.getStringAttackTypeSkill()));
        attacker.setUtilityTypeSkill(hangleToUtilityTypeSkill.get(attacker.getStringUtilityTypeSkill()));
        attacker.setDefenseTypeSkill(hangleToDefensiveTypeSkill.get(attacker.getStringDefenseTypeSkill()));

        defender.setDefenseTypeSkill(hangleToDefensiveTypeSkill.get(defender.getStringDefenseTypeSkill()));
        defender.setAttackTypeSkill(hangleToAttackTypeSkill.get(defender.getStringAttackTypeSkill()));
        defender.setUtilityTypeSkill(hangleToUtilityTypeSkill.get(defender.getStringUtilityTypeSkill()));


        return battleService.conductBattle(request.getAttacker(), request.getDefender());
    }
}
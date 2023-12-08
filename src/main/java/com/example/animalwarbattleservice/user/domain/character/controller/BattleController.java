package com.example.animalwarbattleservice.user.domain.character.controller;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.character.request.CharacterRequest;
import com.example.animalwarbattleservice.user.domain.character.service.BattleService;
import com.example.animalwarbattleservice.user.domain.character.skill.attackType.*;
import com.example.animalwarbattleservice.user.domain.character.skill.defensiveType.*;
import com.example.animalwarbattleservice.user.domain.character.skill.utilityType.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/battle")
public class BattleController {
    private BattleService battleService;

    // hangle은 한글이란 뜻
    private static final HashMap<String, AttackTypeSkill>
            hangleToAttackTypeSkill = new HashMap<>();

    private static final HashMap<String,DefensiveTypeSkill>
            hangleToDefensiveTypeSkill = new HashMap<>();

    private static final HashMap<String, UtilityTypeSkill>
            hangleToUtilityTypeSkill = new HashMap<>();


    @PostMapping
    public List<String> battleCheck(@RequestBody CharacterRequest request) {
        CharacterDto attacker = request.getAttacker();
        CharacterDto defender = request.getDefender();

        hangleToAttackTypeSkill.put("버서커 [35%]", new BerserkerImpl());
        hangleToAttackTypeSkill.put("폭탄 투하 [45%]", new BombDropImpl());
        hangleToAttackTypeSkill.put("처형 [55%]", new ExecutionImpl());
        hangleToAttackTypeSkill.put("비장의 한발 [65%]", new HiddenAceImpl());
        hangleToAttackTypeSkill.put("독약 [65%]", new PoisonImpl());
        hangleToAttackTypeSkill.put("빨리감기 [85%]", new SpeedRunImpl());

        hangleToDefensiveTypeSkill.put("비상식량 [50%]" ,new EmergencyFoodImpl());
        hangleToDefensiveTypeSkill.put("회복 [50%]" ,new HealImpl());
        hangleToDefensiveTypeSkill.put("철통방어 [35%]" ,new IroncladDefenseImpl());
        hangleToDefensiveTypeSkill.put("럭키 7 [17%]" ,new LuckySevenImpl());
        hangleToDefensiveTypeSkill.put("녹슨 방패 [50%]" ,new RustedSwordImpl());
        hangleToDefensiveTypeSkill.put("붕대 감기 [75%]" ,new BandagingImpl());

        hangleToUtilityTypeSkill.put("부러진 창 [10%]" ,new BrokenSpearImpl());
        hangleToUtilityTypeSkill.put("부러진 방패 [10%]" ,new BrokenShieldImpl());
        hangleToUtilityTypeSkill.put("다시하기 [10%]" ,new DoItAgainImpl());
        hangleToUtilityTypeSkill.put("공수교대 [10%]" ,new OffenseDefenseShiftImpl());
        hangleToUtilityTypeSkill.put("강약약강 [10%]" ,new StrongAndWeakImpl());
        hangleToUtilityTypeSkill.put("바꿔치기 [10%]" ,new SwapImpl());


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
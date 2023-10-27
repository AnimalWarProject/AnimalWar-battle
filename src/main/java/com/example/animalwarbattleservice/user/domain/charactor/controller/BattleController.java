package com.example.animalwarbattleservice.user.domain.charactor.controller;

import com.example.animalwarbattleservice.user.domain.charactor.service.CombatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BattleController {
    private CombatService combatService;


}

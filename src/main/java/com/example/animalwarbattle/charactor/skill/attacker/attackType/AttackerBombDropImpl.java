package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttackerBombDropImpl implements AttackerBombDropSkill {
    private final CompatibilityChecker compatibilityChecker;
    @Override
    public Integer bombDrop(Character attacker, Character defender) {
        return null;
    }
}

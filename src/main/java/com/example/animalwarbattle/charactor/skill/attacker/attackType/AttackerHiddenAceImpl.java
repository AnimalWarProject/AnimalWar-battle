package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttackerHiddenAceImpl implements AttackerHiddenAceSkill{
    private final CompatibilityChecker compatibilityChecker;

    @Override
    public Integer hiddenAce(Character attacker, Character defender) {
        return null;
    }
}

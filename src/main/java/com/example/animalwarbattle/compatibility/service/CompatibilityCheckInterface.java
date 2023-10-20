package com.example.animalwarbattle.compatibility.service;

import com.example.animalwarbattle.domain.entity.Character;

public interface CompatibilityCheckInterface {
    public boolean check(Character attacker, Character defender);
}

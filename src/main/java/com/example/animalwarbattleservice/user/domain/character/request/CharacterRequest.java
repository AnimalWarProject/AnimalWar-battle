package com.example.animalwarbattleservice.user.domain.character.request;

import com.example.animalwarbattleservice.user.domain.character.dto.CharacterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {
    private CharacterDto attacker;
    private CharacterDto defender;



    public void setAttacker(CharacterDto attacker) {
        this.attacker = attacker;
    }

    public void setDefender(CharacterDto defender) {
        this.defender = defender;
    }

}

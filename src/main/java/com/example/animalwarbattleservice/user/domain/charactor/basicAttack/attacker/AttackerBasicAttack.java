package com.example.animalwarbattleservice.user.domain.charactor.basicAttack.attacker;

import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.AttackerCharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.domain.dto.DefenderCharacterDto;
import org.springframework.stereotype.Component;

@Component
public interface AttackerBasicAttack {
    Integer attackPlainHit(AttackerCharacterDto attacker, CharacterDto defender);
}

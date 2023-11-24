package com.example.animalwarbattleservice.user.domain.charactor.response;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.dto.CharacterDto;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.utilityType.UtilityTypeSkill;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserResponse {

    private UUID uuid;
    private String id;
    private String nickName;

    private int food;
    private int iron;
    private int wood;
    private int gold;

    private int attackPower;
    private int defensePower;
    private int life;
    private int maxLife;

    private AttackTypeSkill attackTypeSkill;
    private DefensiveTypeSkill defenseTypeSkill;
    private UtilityTypeSkill utilityTypeSkill;

    private CompatibilityEnum compatibilityEnum;

    private int battlePoint;



    public static UserResponse userResponse(CharacterDto characterDto) {
        return UserResponse.builder()
                .id(characterDto.getId())
                .nickName(characterDto.getNickName())
                .attackPower(characterDto.getAttackPower())
                .defensePower(characterDto.getDefensePower())
                .life(characterDto.getLife())
                .maxLife(characterDto.getMaxLife())
                .compatibilityEnum(characterDto.getCompatibilityEnum())
                .attackTypeSkill(characterDto.getAttackTypeSkill())
                .defenseTypeSkill(characterDto.getDefenseTypeSkill())
                .utilityTypeSkill(characterDto.getUtilityTypeSkill())
                .iron(characterDto.getIron())
                .food(characterDto.getFood())
                .wood(characterDto.getWood())
                .gold(characterDto.getGold())
                .build();
    }
}

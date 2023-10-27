package com.example.animalwarbattleservice.user.domain.charactor.domain.entity;


import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.attackType.AttackerAttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.defensiveType.AttackerDefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.attacker.utilityType.AttackerUtilityTypeSkill;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterDto {
    private Long userUUID;
    private String nickName;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;
    private String attackTypeSkill;
    private String defenseTypeSkill;
    private String utilityTypeSkill;


    @Enumerated(EnumType.STRING)
    private CompatibilityEnum compatibility;
    
    // 처형 스킬
    private int executionSkillCount = 5;
    public void decrementExecutionCount(){
        this.executionSkillCount--;
    }

    // 철통 방어 스킬
    private int ironcladDefenseSkillCount = 3;
    public void decrementIroncladDefenseCount(){
        this.ironcladDefenseSkillCount--;
    }


    // 럭키 7-상대공겨 7회 무효
    private int luckySevenSkillCount = 7;
    public void decrementLuckySevenCount(){
        this.luckySevenSkillCount--;
    }
    public void blockBasicAttack(){
        this.isBasicAttack = false;
    }
    private boolean isBasicAttack = true;


    // 부러진 창-공격형 스킬 가능하지
    public void blockAttackSkill(){
        this.isAttackSkill= false;
    }
    private boolean isAttackSkill = true;

    // 부러진 방패-수비형 스킬 가능한지
    public void blockDependSkill(){
        this.isDependSkill= false;
    }
    private boolean isDependSkill = true;

    // 다시하기 스킬
    public void restoreHP(){
        this.life = maxLife;
    }

    // 공격자 수비자 공수전투력 체인지
    public void exchangeAtkDef(){
        int temp = attackerPower;
        this.attackerPower = defensePower;
        this.defensePower = temp;
    }

    // 체력 반환
    public void changeLife(int life){
        this.life = life;
    }

    // 공격력 반환
    public void changeAtkp(int atk){
        this.attackerPower = atk;
    }

    // 수비력 반환
    public void changeDef(int def){
        this.defensePower = def;
    }
}
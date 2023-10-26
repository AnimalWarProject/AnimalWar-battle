package com.example.animalwarbattleservice.user.domain.dto;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 럭키7 스킬
    private int luckySevenSkillCount = 7;
    public void decrementLuckySevenCount(){
        this.luckySevenSkillCount--;
    }

    // 기본 공격과 스킬발동이 가능한지
    private boolean isBasicAttack = true;
    private boolean isAttackSkill = true;
    private boolean isDependSkill = true;

    // 기본공격이 가능한지
    public void blockBasicAttack(){
        this.isBasicAttack = false;
    }

    // 공격형 스킬 가능하지
    public void blockAttackSkill(){
        this.isAttackSkill= false;
    }

    // 수비형 스킬 가능한지
    public void blockDependSkill(){
        this.isDependSkill= false;
    }

    // 최대 체력 한번에 반환
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
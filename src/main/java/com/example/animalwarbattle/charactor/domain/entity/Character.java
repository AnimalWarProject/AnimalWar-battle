package com.example.animalwarbattle.charactor.domain.entity;

import com.example.animalwarbattle.compatibility.domain.CompatibilityEnum;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;


// 스킬 로직처리
@AllArgsConstructor
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userUUID;

    public String userId;
    private String nickName;
    private int attackerPower;
    private int defensePower;
    private int life;
    private int maxLife;
    private String skill;
    private CompatibilityEnum compatibility;
    private int attackSkillCount = 0;
    private int defendSkillCount = 0;
    private int utilSkillCount = 0;

    // 스킬발동이 가능한지
    private boolean isAttack = true;
    private boolean isDepend = true;


    public void blockAttack(){
        this.isAttack=false;
    }

    public void blockDepend(){
        this.isDepend=false;
    }

    public void restoreHP(){
        this.life=maxLife;
    }

    public void exchangeATK_DEF(){
        int temp= attackerPower;
        this.attackerPower=defensePower;
        this.defensePower=temp;


    }

    public void changeLife(int life){
        this.life = life;
    }

    public void changeATKP(int atk){
        this.attackerPower = atk;
    }

    public void changeDef(int def){
        this.defensePower =def;
    }

}


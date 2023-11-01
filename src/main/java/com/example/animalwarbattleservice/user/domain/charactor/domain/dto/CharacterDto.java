package com.example.animalwarbattleservice.user.domain.charactor.domain.dto;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.charactor.basicAttack.BasicAttack;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.charactor.skill.battler.utilityType.UtilityTypeSkill;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CharacterDto {
    @Id
    private Long userUUID;
    private String nickName = "";
    private int battlePower;
    private int life = 9999;
    private int maxLife = 9999;
    private BasicAttack basicAttack;
    private AttackTypeSkill attackTypeSkill;
    private DefensiveTypeSkill defenseTypeSkill;
    private UtilityTypeSkill utilityTypeSkill;

    @Enumerated(EnumType.STRING)
    private CompatibilityEnum compatibilityEnum;

    public void setCompatibility(CompatibilityEnum compatibilityEnum) {
        this.compatibilityEnum = compatibilityEnum;
    }
    // 버서커
    private boolean berserkerActivated = true;
    public boolean isBerserkerActivated() {
        return berserkerActivated;
    }
    public void setBerserkerActivated(boolean berserkerActivated) {
        this.berserkerActivated = berserkerActivated;
    }
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
    private boolean isBasicAttackBlocked = false;
    private int luckySevenSkillCount = 7;
    private boolean isBasicAttack = true;
    public void decrementLuckySevenCount(){
        this.luckySevenSkillCount--;
    }

    // 기본 공격 차단
    public void blockBasicAttack(){
        this.isBasicAttackBlocked = true;
    }
    public boolean isBasicAttack() {
        return isBasicAttack;
    }
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
        int temp = battlePower;
        this.battlePower = temp;
    }
    // 체력 반환
    public void changeLife(int life){
        this.life = life;
    }
    public void changeMaxLife(int life){
        this.maxLife = maxLife;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    // 공격력 반환
    public void changeBattlePower(int atk){
        this.battlePower = atk;
    }

    // 스킬들 setter
    public void setAttackTypeSkill(AttackTypeSkill attackTypeSkill) {
        this.attackTypeSkill = attackTypeSkill;
    }
    public void setDefenseTypeSkill(DefensiveTypeSkill defenseTypeSkill) {
        this.defenseTypeSkill = defenseTypeSkill;
    }
    public void setUtilityTypeSkill(UtilityTypeSkill utilityTypeSkill) {
        this.utilityTypeSkill = utilityTypeSkill;
    }
}
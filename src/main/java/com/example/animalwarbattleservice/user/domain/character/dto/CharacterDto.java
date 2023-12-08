package com.example.animalwarbattleservice.user.domain.character.dto;

import com.example.animalwarbattleservice.compatibility.domain.CompatibilityEnum;
import com.example.animalwarbattleservice.user.domain.character.skill.attackType.AttackTypeSkill;
import com.example.animalwarbattleservice.user.domain.character.skill.defensiveType.DefensiveTypeSkill;
import com.example.animalwarbattleservice.user.domain.character.skill.utilityType.UtilityTypeSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class CharacterDto {
    private UUID uuid;
    private String id;
    private String nickName;

    private int attackPower;
    private int defensePower;
    private int life;
    private int maxLife;
    private AttackTypeSkill attackTypeSkill;
    private DefensiveTypeSkill defenseTypeSkill;
    private UtilityTypeSkill utilityTypeSkill;

    private String stringAttackTypeSkill;
    private String stringDefenseTypeSkill;
    private String stringUtilityTypeSkill;

    private String profileImage;

    private int food;
    private int iron;
    private int wood;
    private int gold;
    private int battlePoint;

    // 상성 체크
    private CompatibilityEnum compatibilityEnum;
    private String species;
    public void setCompatibility(CompatibilityEnum compatibilityEnum) {
        this.compatibilityEnum = compatibilityEnum;
    }

    // 녹슨방패 스킬
    private Boolean rustedSwordActivated = false;
    private boolean rustedSwordUsed = false;
    public boolean isRustedSwordActivated() {
        return rustedSwordActivated;
    }
    public void setRustedSwordActivated(boolean rustedSwordActivated) {
        this.rustedSwordActivated = rustedSwordActivated;
    }

    // 버서커 스킬
    private Boolean berserkerActivated = false;
    private boolean berserkerUsed = false;
    public boolean isBerserkerActivated() {
        return berserkerActivated;
    }
    public void setBerserkerActivated(boolean berserkerActivated) {
        this.berserkerActivated = berserkerActivated;
    }
    public void changeBerserkerUsed(){
        this.berserkerUsed = !this.berserkerUsed;
    }

    // 처형 스킬
    private int executionSkillCount = 5;
    public void decrementExecutionCount(){
        this.executionSkillCount--;
    }
    
    // 붕대감기 스킬
    private int bandagingSkillCount = 3;
    private Integer isBanding  = 0;
    private Boolean bandingActivated = false;
    public void changeBanding(Integer num) {
        this.isBanding = num;
    }
    public void decreaseBandingCheck(){
        this.isBanding -= 1;
    }
    private boolean isBandingSkill = true;
    public Integer isBandingHeal() {
        return isBanding;
    }

    // 철통방어 스킬
    private int ironcladDefenseSkillCount = 3;

    // 럭키 7-상대공격 7회 무효
    private int luckySevenSkillCount = 7;
    private Integer isBasicAttack = 0;

    public void changeBasicAttack(Integer num){
        this.isBasicAttack = num;
    }

    // 기본 공격 차단
    public Integer isBasicAttack() {
        return isBasicAttack;
    }
    public void decreaseBasicAttack(){
        this.isBasicAttack -= 1;
    }

    // 부러진 창-공격형 스킬 가능하지
    public void blockAttackSkill(){
        this.isAttackSkill= false;}
    private boolean isAttackSkill = true;

    // 부러진 방패-수비형 스킬 가능한지
    public void blockDependSkill(){
        this.isDependSkill= false;}
    private boolean isDependSkill = true;

    // 다시하기 스킬
    public void restoreHP(){
        this.life = maxLife;}

    // 공격자 수비자 공수전투력 체인지
    public void exchangeAtkDef(){
        int temp = defensePower;
        this.attackPower = temp;}

    // 체력 반환
    public void changeLife(int life){
        this.life = life;
    }

    // 공격력 반환
    public void changeBattlePower(int atk){
        this.attackPower = atk;
    }

    // 수비력 반환
    public void changeDefenderPower(int dtk){
        this.defensePower = dtk;
    }

    // 스킬 유형 setter
    public void setAttackTypeSkill(AttackTypeSkill attackTypeSkill) {
        this.attackTypeSkill = attackTypeSkill;}
    public void setDefenseTypeSkill(DefensiveTypeSkill defenseTypeSkill) {
        this.defenseTypeSkill = defenseTypeSkill;}
    public void setUtilityTypeSkill(UtilityTypeSkill utilityTypeSkill) {
        this.utilityTypeSkill = utilityTypeSkill;}
}
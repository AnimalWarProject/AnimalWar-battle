//package com.example.animalwarbattle.charactor.count;
//
//
//public class AttackBattleCountServiceImpl implements BattleCountService {
//    // 유틸형 스킬 횟수
//    private int utilSkillCount;
//    // 공격형 스킬 횟수
//    private int attackSkillCount;
//    // 수비형 스킬 횟수
//    private int defendSkillCount;
//
//    // 유틸형 스킬 횟수 증가 메서드
//    @Override
//    public void incrementUtilCount() {
//        utilSkillCount++;
//    }
//
//    // 공격형 스킬 횟수 증가 메서드
//    @Override
//    public void incrementAttackCount() {
//        attackSkillCount++;
//    }
//
//    // 수비형 스킬 횟수 증가 메서드
//    @Override
//    public void incrementDefendCount() {
//        defendSkillCount++;
//    }
//
//    // 유틸형 스킬 횟수 반환 메서드
//    @Override
//    public int getUtilCount() {
//        return utilSkillCount;
//    }
//
//    // 공격형 스킬 횟수 반환 메서드
//    @Override
//    public int getAttackCount() {
//        return attackSkillCount;
//    }
//
//    // 수비형 스킬 횟수 반환 메서드
//    @Override
//    public int getDefendCount() {
//        return defendSkillCount;
//    }
//
//    // 모든 스킬 횟수를 초기화하는 메서드
//    @Override
//    public void resetCounts() {
//        utilSkillCount = 0;
//        attackSkillCount = 0;
//        defendSkillCount = 0;
//    }
//
//    // 처형 스킬 적용 기간 여부를 확인하는 메서드
//    @Override
//    public boolean isWithinExecutionPeriod() {
//        return attackSkillCount <= 5;
//    }
//
//    @Override
//    public boolean isWithinBrokenShieldPeriod(){
//        return defendSkillCount <=3;
//    }
//}

package com.example.animalwarbattle.charactor.skill.defender.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.service.AttackBattleCountService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefenderExecutionImpl implements DefenderExecutionSkill {
    private final AttackBattleCountService attackBattleCountService;

    @Override
    public Integer execution(Character attacker, Character defender) {
        // 1. 처형 스킬 발동 설정
        int currentBattleCount = attackBattleCountService.getDefendCount();
        int attackerLife = attacker.getLife();
        int attackerMaxLife = attacker.getMaxLife();
        if (currentBattleCount <= 5 && attackerLife < 0.1 * attackerMaxLife){
            System.out.println("처형 적용");
            if (attackerLife <= 0) {
                System.out.println("공격자 처형됨");
            }else {
                System.out.println("처형이 적용되지 않았습니다.");
            }
        }
        return attackerLife;
    }
}

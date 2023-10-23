package com.example.animalwarbattle.charactor.skill.attacker.attackType;

import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.service.AttackBattleCountService;
import com.example.animalwarbattle.compatibility.service.CompatibilityChecker;
import lombok.AllArgsConstructor;

/*  처형 : 공격 5회 이내, 상대방이 10%의 체력 미만이라면 처형합니다.  */
@AllArgsConstructor
public class AttackerExecutionImpl implements AttackerExecutionSkill {
    private final AttackBattleCountService attackBattleCountService;

    @Override
    public Integer execution(Character attacker, Character defender) {
        // 1. 처형 스킬 발동 설정
        int currentBattleCount = attackBattleCountService.getAttackCount();
        int defenderLife = defender.getLife();
        int defenderMaxLife = defender.getMaxLife();
        // 2. 스킬 사용
        if (currentBattleCount <= 5 && defenderLife < 0.1 * defenderMaxLife) {
            System.out.println("처형 적용");
            if (defenderLife <= 0) {
                System.out.println("수비자 처형됨");
            } else {
                System.out.println("처형이 적용되지 않았습니다.");
            }
        }
        return defenderLife;
    }
}

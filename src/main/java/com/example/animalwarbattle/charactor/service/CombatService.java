package com.example.animalwarbattle.charactor.service;

import com.example.animalwarbattle.charactor.basicAttack.attacker.BasicAttack;
import com.example.animalwarbattle.charactor.basicAttack.defender.BasicDefend;
import com.example.animalwarbattle.charactor.domain.entity.Character;
import com.example.animalwarbattle.charactor.skill.attacker.attackType.*;
import com.example.animalwarbattle.charactor.skill.defender.attackType.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CombatService {
    private final AttackBattleCountServiceImpl countService;

    private final BasicAttack basicAttack;
    private final BasicDefend basicDefend;
    // 공격형 스킬
    private AttackerAttackTypeSkill attackerTypeSkill;
    private DefenderAttackTypeSkill defenderTypeSkill;
    
    // 수비형 스킬
    
    // 유틸형 스킬



    public void oneTurnFight(Character attacker, Character defender){
        attackerTypeSkill = useAttackerAttackTypeSkill(attacker ,defender);
        defenderTypeSkill = useDefenderAttackTypeSkill(attacker, defender);

        // 여기는 스킬을 사용하는 로직이다
        attackerTypeSkill.attackTypeAttackerExecute(attacker,  defender);

        //여기는 스킬 사용 후 피가 깍였을 때 즉결처형 해야하는지 확인하는 로직이다
        if (attacker.getAttackSkillCount() > 0){
            if (defender.getLife() <= defender.getMaxLife()/10){
                defender.setLife(0);
            }
            attacker.setAttackSkillCount(attacker.getAttackSkillCount() - 1);
        }
    }

    // 공격자 스킬 랜덤
    public AttackerAttackTypeSkill useAttackerAttackTypeSkill(Character attacker, Character defender){
        //random 으로 스킬 하나 가져오는 로직 필요
        List<AttackerAttackTypeSkill> randomAttackerSkill = List.of(
                new AttackerBerserkerImpl(),
                new AttackerBombDropImpl(),
                new AttackerExecutionImpl(),
                new AttackerHiddenAceImpl(),
                new AttackerPoisonImpl(),
                new AttackerSpeedRunImpl()
        );
        Random random = new Random();
        int index = random.nextInt(randomAttackerSkill.size());
        return randomAttackerSkill.get(index);

    }

    // 수비자 스킬 랜덤
    public DefenderAttackTypeSkill useDefenderAttackTypeSkill(Character attacker, Character defender){
        //random 으로 스킬 하나 가져오는 로직 필요
        List<DefenderAttackTypeSkill> randomDefenderSkill = List.of(
                new DefenderBerserkerImpl(),
                new DefenderBombDropImpl(),
                new DefenderExecutionImpl(),
                new DefenderHiddenAceImpl(),
                new DefenderPoisonImpl(),
                new DefenderSpeedRunImpl()
        );
        Random random = new Random();
        int index = random.nextInt(randomDefenderSkill.size());
        return randomDefenderSkill.get(index);
    }
}

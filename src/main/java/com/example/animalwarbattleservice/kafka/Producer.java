package com.example.animalwarbattleservice.kafka;


import com.example.animalwarbattleservice.user.domain.character.dto.UserUpdateByGameResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.animalwarbattleservice.kafka.Topics.GAME_RESULT_TOPIC;

@Service
@RequiredArgsConstructor
public class Producer {
    private final KafkaTemplate<String, UserUpdateByGameResultDto> template;


    public void send(UserUpdateByGameResultDto request){
        template.send(GAME_RESULT_TOPIC, request);
    }

}

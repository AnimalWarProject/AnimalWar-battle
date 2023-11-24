package com.example.animalwarbattleservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;


@Component
public class Topics {
    public final static String GAME_RESULT_TOPIC = "game-result-topic";

    @Bean
    public NewTopic GAME_RESULT_TOPIC(){
        return TopicBuilder
                .name(GAME_RESULT_TOPIC)
                .replicas(1)
                .partitions(1)
                .build();
    }

}

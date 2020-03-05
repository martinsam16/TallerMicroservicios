package com.kafka.consumer.listener;

import com.kafka.consumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumo de mensaje: " + message);
    }

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJSON(User user) {
        System.out.println("Consumo de json: " + user);
    }
}

package com.martinsaman.consumer.services;

import com.google.gson.Gson;
import com.martinsaman.consumer.dto.DataDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "DatabaseTopic", groupId = "com.martinsaman")
    public void consume(String message) {
        try {
            DataDto data = new Gson().fromJson(message, DataDto.class);
            System.out.println("RECIBIDO:" + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

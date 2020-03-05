package com.martinsaman.consumer.services;

import com.google.gson.Gson;
import com.martinsaman.consumer.clients.ICassandra;
import com.martinsaman.consumer.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private ICassandra cassandraClient;

    @KafkaListener(topics = "DatabaseTopic", groupId = "com.martinsaman")
    public void consume(String message) {
        try {
            DataDto data = new Gson().fromJson(message, DataDto.class);
            System.out.println("RECIBIDO:" + data);
            System.out.println(action(data));   //TODO websocket para mandarlo..?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object action(DataDto data) {
        switch (data.getDatabaseEvent()) {

            case SAVE:
                return cassandraClient.save(data.getPersona());

            case UPDATE:
                return cassandraClient.update(data.getPersona());

            case DELETE:
                return cassandraClient.delete(data.getPersona());

            default:
                System.out.println(":c");
                return null;
        }

    }
}

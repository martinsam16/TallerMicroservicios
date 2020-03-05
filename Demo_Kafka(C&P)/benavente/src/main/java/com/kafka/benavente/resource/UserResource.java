package com.kafka.benavente.resource;

import com.kafka.benavente.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String name){
        kafkaTemplate.send(TOPIC, new User(name, "Benavente", 1200L));
        return "Publicación exitosa";
    }

}

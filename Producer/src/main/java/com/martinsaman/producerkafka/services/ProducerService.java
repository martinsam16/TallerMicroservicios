package com.martinsaman.producerkafka.services;

import com.martinsaman.producerkafka.dto.DataDto;
import com.martinsaman.producerkafka.dto.PersonaDto;
import com.martinsaman.producerkafka.types.DatabaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, DataDto> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void enviar(DataDto dataDto) {
        kafkaTemplate.send(topicName, dataDto);
    }

    public void enviar(PersonaDto personaDto, DatabaseEvent event) {
        enviar(new DataDto(event, personaDto));
    }

}

package com.martinsaman.producerkafka.rest;

import com.martinsaman.producerkafka.dto.DataDto;
import com.martinsaman.producerkafka.dto.PersonaDto;
import com.martinsaman.producerkafka.services.ProducerService;
import com.martinsaman.producerkafka.types.DatabaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/producer")
public class ProducerRest {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public void save(@RequestBody PersonaDto personaDto) {
        producerService.enviar(personaDto, DatabaseEvent.SAVE);
    }

    @PutMapping
    public void update(@RequestBody PersonaDto personaDto) {
        producerService.enviar(personaDto, DatabaseEvent.UPDATE);
    }

    @DeleteMapping
    public void delete(@RequestBody PersonaDto personaDto) {
        producerService.enviar(personaDto, DatabaseEvent.DELETE);
    }

    @PostMapping("/dto")
    public void enviar(@RequestBody DataDto dataDto) {
        producerService.enviar(dataDto);
    }
}

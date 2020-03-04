package com.martinsaman.producerkafka.rest;

import com.martinsaman.producerkafka.dto.DataDto;
import com.martinsaman.producerkafka.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/producer")
public class ProducerRest {

    @Autowired
    ProducerService producerService;

    @PostMapping
    public void enviar(@RequestBody DataDto dataDto){
        producerService.enviar(dataDto);
    }
}

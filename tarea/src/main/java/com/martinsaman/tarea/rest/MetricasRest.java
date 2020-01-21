package com.martinsaman.tarea.rest;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricasRest {

    @Autowired
    MeterRegistry registry;

    @GetMapping
    public String hola() {
        registry.counter("peticionesRest").increment();
        return "Hola C: " + registry.get("peticionesRest").counter().count();
    }
}

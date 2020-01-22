package com.martinsaman.tarea.rest;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricasRest {

    @Autowired
    MeterRegistry registry;

    @GetMapping("/hola")
    public String hola() {
        registry.counter("peticionesRestHola").increment();
        return "Hola C: " + registry.get("peticionesRestHola").counter().count();
    }


    @GetMapping("/demo")
    public String demo() {
        Counter counter = Counter
                .builder("peticionesRestDemo")
                .description("Numero de peticiones a Demo xdxd")
                .register(registry);
        counter.increment();
        return "ahaha " + counter.count();
    }

}

package com.martinsaman.tarea.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricasRest {

    @GetMapping
    public String hola() {
        return "Hola C:";
    }
}

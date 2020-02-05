package com.example.demo.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HolaMundo {

    @GetMapping
    public String hola(){
        return "Hola Mundo xdxd";
    }
}

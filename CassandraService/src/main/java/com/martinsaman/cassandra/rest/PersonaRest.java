package com.martinsaman.cassandra.rest;

import com.martinsaman.cassandra.persistence.Persona;
import com.martinsaman.cassandra.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaRest {


    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return personaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @DeleteMapping
    public ResponseEntity<Persona> delete(@RequestBody Persona persona) {
        return personaService.delete(persona);
    }

}

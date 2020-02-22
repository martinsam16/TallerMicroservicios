package com.martinsaman.springsecurity.rest;

import com.martinsaman.springsecurity.persistence.IPersona;
import com.martinsaman.springsecurity.persistence.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaRest {

    @Autowired
    private IPersona repo;

    @GetMapping
    public List<Persona> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Persona findOne(@PathVariable("id") String id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Persona registar(@RequestBody Persona persona) {
        return repo.save(persona);
    }

    @PutMapping
    public Persona actualizar(@RequestBody Persona persona) {
        return repo.save(persona);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") String id) {
        repo.deleteById(id);
    }

}

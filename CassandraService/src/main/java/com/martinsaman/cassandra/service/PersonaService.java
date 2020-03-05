package com.martinsaman.cassandra.service;

import com.martinsaman.cassandra.persistence.IPersona;
import com.martinsaman.cassandra.persistence.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersona repo;


    public ResponseEntity<List<Persona>> findAll() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.FOUND);
    }


    public ResponseEntity<Persona> save(Persona persona) {
        return new ResponseEntity<>(repo.save(persona), HttpStatus.CREATED);
    }


    public ResponseEntity<Persona> update(Persona persona) {
        Optional<Persona> optionalPersona = repo.findById(persona.getDni());
        if (optionalPersona.isPresent()) {
            return new ResponseEntity<>(repo.save(persona), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Persona> delete(Persona persona) {
        try {
            repo.delete(persona);
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

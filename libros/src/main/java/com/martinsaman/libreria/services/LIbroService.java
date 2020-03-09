package com.martinsaman.libreria.services;

import com.martinsaman.libreria.persistence.ILibro;
import com.martinsaman.libreria.persistence.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LIbroService {


    @Autowired
    private ILibro repo;

    public ResponseEntity<List<Libro>> findAll() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Libro> save(
            Libro libro
    ) {
        return new ResponseEntity<>(repo.save(libro), HttpStatus.CREATED);
    }

    public ResponseEntity<Libro> update(
            Libro libro
    ) {
        Optional<Libro> libroEncontrado = repo.findById(libro.getIsbnLibro());
        if (libroEncontrado.isPresent()) {
            return new ResponseEntity<>(repo.save(libro), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> delete(
            Libro libro
    ) {
        repo.delete(libro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

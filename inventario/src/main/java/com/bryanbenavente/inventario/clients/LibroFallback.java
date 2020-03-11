package com.bryanbenavente.inventario.clients;

import com.bryanbenavente.inventario.persistence.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroFallback implements LibroClient{

    @Override
    public ResponseEntity<List<Libro>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Libro> save(Libro libro) {
        System.out.println("El servicio de libro se murio");
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Libro> update(Libro libro) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Libro libro) {
        return null;
    }

}

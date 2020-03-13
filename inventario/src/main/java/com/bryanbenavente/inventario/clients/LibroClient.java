package com.bryanbenavente.inventario.clients;

import com.bryanbenavente.inventario.persistence.Libro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "libro",fallback = LibroFallback.class)
public interface LibroClient {

    @GetMapping
    ResponseEntity<List<Libro>> findAll();

    @PostMapping
    ResponseEntity<Libro> save(
            @RequestBody Libro libro
    );

    @PutMapping
    ResponseEntity<Libro> update(
            @RequestBody Libro libro
    );

    @DeleteMapping
    ResponseEntity<Void> delete(
            @RequestBody Libro libro
    );

}

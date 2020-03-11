package com.bryanbenavente.inventario.rest;

import com.bryanbenavente.inventario.persistence.Inventario;
import com.bryanbenavente.inventario.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InventarioRest {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> findAll() {
        return inventarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<Inventario> create(Inventario inventario) {
        return inventarioService.save(inventario);
    }

    @PutMapping
    public ResponseEntity<Inventario> update(Inventario inventario) {
        return inventarioService.save(inventario);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Inventario inventario) {
        return inventarioService.delete(inventario);
    }
}

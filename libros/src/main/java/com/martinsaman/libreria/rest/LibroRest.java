package com.martinsaman.libreria.rest;

import com.martinsaman.libreria.dto.VentaDto;
import com.martinsaman.libreria.persistence.Libro;
import com.martinsaman.libreria.services.LIbroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class LibroRest {

    @Autowired
    private LIbroService lIbroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findAll() {
        return lIbroService.findAll();
    }

    @PostMapping
    public ResponseEntity<Libro> save(
           @RequestBody Libro libro
    ) {
        return lIbroService.save(libro);
    }

    @PostMapping("/vender")
    public ResponseEntity<Object> vender(
            @RequestBody VentaDto ventaDto
    ){
        return lIbroService.vender(ventaDto);
    }

    @PutMapping
    public ResponseEntity<Libro> update(
            @RequestBody Libro libro
    ) {
        return lIbroService.update(libro);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody Libro libro
    ) {
        return lIbroService.delete(libro);
    }


}

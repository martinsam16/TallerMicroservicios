package com.martinsaman.ventas.rest;

import com.martinsaman.ventas.dto.InventarioDto;
import com.martinsaman.ventas.persistence.Libro;
import com.martinsaman.ventas.persistence.Venta;
import com.martinsaman.ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VentaRest {

    @Autowired
    private VentaService ventaService;


    @GetMapping
    public ResponseEntity<List<Venta>> findAll(){
        return ventaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Venta> save(
            @RequestBody Venta venta
    ) {
        return ventaService.save(venta);
    }

    @PutMapping
    public ResponseEntity<Venta> update(
            @RequestBody Venta venta
    ){
        return ventaService.update(venta);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody Venta venta
    ){
        return ventaService.delete(venta);
    }

    @PostMapping("/inventario")
    public ResponseEntity<Object> vender(
            @RequestBody InventarioDto inventarioDto
    ){
        return ventaService.inventario(inventarioDto);
    }

}

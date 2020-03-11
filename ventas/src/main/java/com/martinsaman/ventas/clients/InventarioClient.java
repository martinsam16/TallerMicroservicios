package com.martinsaman.ventas.clients;

import com.martinsaman.ventas.dto.InventarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventarioClient",url = "localhost:2022",fallback = InventarioFallback.class)
public interface InventarioClient {

    @GetMapping
    ResponseEntity<List<InventarioDto>> findAll();

    @PostMapping
    ResponseEntity<InventarioDto> save(
            @RequestBody InventarioDto inventario
    );

    @PutMapping
    ResponseEntity<InventarioDto> update(
            @RequestBody InventarioDto inventario
    );

    @DeleteMapping
    ResponseEntity<Void> delete(
            @RequestBody InventarioDto inventario
    );

}

package com.martinsaman.libreria.clients;

import com.martinsaman.libreria.dto.VentaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ventaClient",url = "localhost:2021",fallback = VentaFallback.class)
public interface VentaClient {

    @GetMapping
    ResponseEntity<List<VentaDto>> findAll();

    @PostMapping
    ResponseEntity<VentaDto> save(
            @RequestBody VentaDto venta
    );

    @PutMapping
    ResponseEntity<VentaDto> update(
            @RequestBody VentaDto venta
    );

    @DeleteMapping
    ResponseEntity<Void> delete(
            @RequestBody VentaDto venta
    );

}

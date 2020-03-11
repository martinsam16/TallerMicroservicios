package com.martinsaman.ventas.clients;

import com.martinsaman.ventas.dto.InventarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventarioFallback implements InventarioClient {

    @Override
    public ResponseEntity<List<InventarioDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<InventarioDto> save(InventarioDto inventario) {
        System.out.println("Error en el servicio de inventario");
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<InventarioDto> update(InventarioDto inventario) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(InventarioDto inventario) {
        return null;
    }

}

package com.martinsaman.libreria.clients;

import com.martinsaman.libreria.dto.VentaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaFallback implements VentaClient{
    @Override
    public ResponseEntity<List<VentaDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<VentaDto> save(VentaDto venta) {
        System.out.println("El servicio de venta cayo, como su amor x ti xdxd");
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<VentaDto> update(VentaDto venta) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(VentaDto venta) {
        return null;
    }
}

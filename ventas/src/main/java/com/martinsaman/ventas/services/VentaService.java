package com.martinsaman.ventas.services;

import com.martinsaman.ventas.persistence.IVenta;
import com.martinsaman.ventas.persistence.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private IVenta repo;

    public ResponseEntity<List<Venta>> findAll(){
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Venta> save(
            Venta venta
    ) {
        venta.calcularTotal();
        return new ResponseEntity<>(repo.save(venta), HttpStatus.CREATED);
    }

    public ResponseEntity<Venta> update(
            Venta venta
    ){
        Optional<Venta> ventaEncontrado = repo.findById(venta.getId());
        if (ventaEncontrado.isPresent()){
            return new ResponseEntity<>(repo.save(venta),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> delete(
            Venta venta
    ){
        repo.delete(venta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

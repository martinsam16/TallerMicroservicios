package com.martinsaman.ventas.services;

import com.martinsaman.ventas.persistence.ILibro;
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
    private IVenta repoVenta;

    @Autowired
    private ILibro repoLibro;

    public ResponseEntity<List<Venta>> findAll(){
        return new ResponseEntity<>(repoVenta.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Venta> save(
            Venta venta
    ) {
        venta.calcularTotal();
        repoLibro.save(venta.getLibro());   //TODO sync con kafka
        return new ResponseEntity<>(repoVenta.save(venta), HttpStatus.CREATED);
    }

    public ResponseEntity<Venta> update(
            Venta venta
    ){
        Optional<Venta> ventaEncontrado = repoVenta.findById(venta.getId());
        if (ventaEncontrado.isPresent()){
            return new ResponseEntity<>(repoVenta.save(venta),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> delete(
            Venta venta
    ){
        repoVenta.delete(venta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

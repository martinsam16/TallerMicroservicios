package com.bryanbenavente.inventario.services;

import com.bryanbenavente.inventario.clients.LibroClient;
import com.bryanbenavente.inventario.persistence.IInventario;
import com.bryanbenavente.inventario.persistence.ILibro;
import com.bryanbenavente.inventario.persistence.Inventario;
import com.bryanbenavente.inventario.persistence.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private ILibro repoLibro;

    @Autowired
    private IInventario repoInventario;

    @Autowired
    private LibroClient libroClient;

    public ResponseEntity<List<Inventario>> findAll() {
        return new ResponseEntity<>(repoInventario.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Inventario> save(Inventario inventario) {
        System.out.println(inventario.getLibro());
        repoLibro.save(inventario.getLibro());
        return new ResponseEntity<>(repoInventario.save(inventario), HttpStatus.CREATED);
    }

    public ResponseEntity<Inventario> update(Inventario inventario){
        Optional<Inventario> inventarioEncontrado = repoInventario.findById(inventario.getId());
        if(inventarioEncontrado.isPresent()){
            return new ResponseEntity<>(repoInventario.save(inventario), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> delete(Inventario inventario){
        repoInventario.delete(inventario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> libro(
            Libro libro
    ){
        if(repoLibro.findById(libro.getIsbnLibro()).isPresent()){
            ResponseEntity<Libro> rpta = libroClient.save(libro);
            return new ResponseEntity<>(rpta.getBody(),rpta.getStatusCode());
        }else {
            return new ResponseEntity<>("No se encuentra registrado",HttpStatus.NOT_FOUND);
        }
    }

}

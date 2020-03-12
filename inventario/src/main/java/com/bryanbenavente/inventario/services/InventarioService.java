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

    public ResponseEntity<Object> inventario(
            Inventario inventario
    ){
        if (inventario.getTipo().equals("I")){
            ResponseEntity<Libro> rpta = libroClient.save(inventario.getLibro());
            if (rpta.getStatusCode() == HttpStatus.CREATED){
                return new ResponseEntity<>(save(inventario),HttpStatus.CREATED);
            }
            return new ResponseEntity<>(rpta.getBody(),rpta.getStatusCode());
        }else{
            if(repoLibro.findById(inventario.getLibro().getIsbnLibro()).isPresent()){
                Optional<Integer> totalLibros = repoInventario.totalLibros(inventario.getLibro().getIsbnLibro());
                System.out.println("Total libros:"+totalLibros);
                if (totalLibros.isPresent()){
                    if (inventario.getCantidad() > totalLibros.get()){
                        return new ResponseEntity<>("No puedes sacar mas de lo que tienes xd",HttpStatus.BAD_REQUEST);
                    }
                }
                return new ResponseEntity<>(save(inventario),HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>("No esta inventariado xd",HttpStatus.NO_CONTENT);
            }
        }

    }

}

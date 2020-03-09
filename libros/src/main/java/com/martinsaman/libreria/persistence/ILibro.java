package com.martinsaman.libreria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ILibro extends JpaRepository<Libro, String> {

    @Transactional
    @Query("update Libro set cantidadLibros=cantidadLibros+:cantidad where isbnLibro=:isbn")
    Libro agregarLibros(@Param("cantidad") Integer cantidadAgregar,@Param("isbn") String isbn);

    @Transactional
    @Query("update Libro set cantidadLibros=cantidadLibros-:cantidad where isbnLibro=:isbn")
    Libro quitarLibros(@Param("cantidad") Integer cantidadQuitar,@Param("isbn") String isbn);
}

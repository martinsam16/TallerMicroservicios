package com.bryanbenavente.inventario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInventario extends JpaRepository<Inventario, Long> {

    @Query("SELECT SUM(inv.cantidad) FROM Inventario inv where inv.libro.isbnLibro=:id")
    Optional<Integer> totalLibros(@Param("id") String id);
}

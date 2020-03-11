package com.bryanbenavente.inventario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibro extends JpaRepository<Libro, String> {
}

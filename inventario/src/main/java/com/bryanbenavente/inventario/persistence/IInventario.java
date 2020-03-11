package com.bryanbenavente.inventario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventario extends JpaRepository<Inventario, Long> {
}

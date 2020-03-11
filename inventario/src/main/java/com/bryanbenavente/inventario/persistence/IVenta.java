package com.bryanbenavente.inventario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVenta extends JpaRepository<Venta, Long> {
}

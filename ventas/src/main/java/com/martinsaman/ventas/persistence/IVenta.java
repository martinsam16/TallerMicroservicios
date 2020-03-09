package com.martinsaman.ventas.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenta extends JpaRepository<Venta,Long> {
}

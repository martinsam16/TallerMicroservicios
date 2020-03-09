package com.martinsaman.libreria.dto;

import com.martinsaman.libreria.persistence.Libro;


public class VentaDto {

    Libro libro;
    Integer cantidad;
    Double total;

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

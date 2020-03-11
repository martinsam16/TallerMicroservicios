package com.bryanbenavente.inventario.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Libro {

    @Id
    private String isbnLibro;
    private String nombreLibro;
    private Double precioLibro;

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(Double precioLibro) {
        this.precioLibro = precioLibro;
    }

}

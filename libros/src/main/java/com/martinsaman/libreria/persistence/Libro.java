package com.martinsaman.libreria.persistence;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Libro implements Serializable {

    @Id
    private String isbnLibro;
    private String nombreLibro;
    private Double precioLibro;

    public Libro() {
    }

    public Libro(String isbnLibro, String nombreLibro, Double precioLibro){
        this.isbnLibro = isbnLibro;
        this.nombreLibro = nombreLibro;
        this.precioLibro = precioLibro;
    }

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

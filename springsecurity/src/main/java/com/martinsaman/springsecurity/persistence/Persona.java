package com.martinsaman.springsecurity.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    @Column(unique = true)
    private String dni;

    @NotNull
    private Boolean isUser;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellidos, String dni, Boolean isUser) {
        this.id = id;
        this.apellidos = apellidos;
        this.dni = dni;
        this.isUser = isUser;
    }

    public Persona(String nombre, String apellidos, String dni, Boolean isUser) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.isUser = isUser;
    }
}

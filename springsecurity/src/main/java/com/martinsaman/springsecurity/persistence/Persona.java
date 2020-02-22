package com.martinsaman.springsecurity.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "Persona")
@Data
public class Persona implements Serializable {

    @Id
    private String id;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String dni;

    @NotNull
    private Boolean isUser;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellidos, String dni, Boolean isUser) {
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

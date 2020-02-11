package com.martinsaman.repositoryrestresource.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class ProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idprod;

    private String nomprod;

    private Double preprod;

}

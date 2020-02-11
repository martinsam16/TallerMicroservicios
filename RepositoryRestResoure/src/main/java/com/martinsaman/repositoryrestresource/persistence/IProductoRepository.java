package com.martinsaman.repositoryrestresource.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
        path = "producto",
        collectionResourceRel = "producto"
)
public interface IProductoRepository extends MongoRepository<ProductoEntity, String> {

    //    http://localhost:7980/api/producto/search/findByNomprod?nombre=demo
    List<ProductoEntity> findByNomprod(@Param(value = "nombre") String nomprod);
}

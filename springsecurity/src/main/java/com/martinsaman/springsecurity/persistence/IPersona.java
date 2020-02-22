package com.martinsaman.springsecurity.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface IPersona extends MongoRepository<Persona, String> {

    Optional<Persona> findPersonaByDni(@NotEmpty String dni);

}

package com.martinsaman.springsecurity.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface IPersona extends JpaRepository<Persona, Long> {

    Optional<Persona> findPersonaByDni(@NotEmpty String dni);

}

package com.martinsaman.cassandra.persistence;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IPersona extends CassandraRepository<Persona, String> {
}

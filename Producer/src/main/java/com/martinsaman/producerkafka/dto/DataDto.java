package com.martinsaman.producerkafka.dto;

import com.martinsaman.producerkafka.types.DatabaseEvent;

public class DataDto {

    private DatabaseEvent databaseEvent;
    private PersonaDto persona;

    public DataDto() {
    }

    public DataDto(DatabaseEvent databaseEvent, PersonaDto persona) {
        this.databaseEvent = databaseEvent;
        this.persona = persona;
    }

    public DatabaseEvent getDatabaseEvent() {
        return databaseEvent;
    }

    public void setDatabaseEvent(DatabaseEvent databaseEvent) {
        this.databaseEvent = databaseEvent;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "databaseEvent=" + databaseEvent +
                ", persona=" + persona +
                '}';
    }
}


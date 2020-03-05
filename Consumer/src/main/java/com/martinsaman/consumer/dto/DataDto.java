package com.martinsaman.consumer.dto;

import com.martinsaman.consumer.types.DatabaseEvent;

public class DataDto {

    private DatabaseEvent databaseEvent;
    private PersonaDto persona;

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

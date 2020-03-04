package com.martinsaman.producerkafka.dto;

import com.martinsaman.producerkafka.types.DatabaseEvent;

public class DataDto {

    private DatabaseEvent databaseEvent;
    private Object data;

    public DatabaseEvent getDatabaseEvent() {
        return databaseEvent;
    }

    public void setDatabaseEvent(DatabaseEvent databaseEvent) {
        this.databaseEvent = databaseEvent;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "databaseEvent='" + databaseEvent + '\'' +
                ", data=" + data +
                '}';
    }
}


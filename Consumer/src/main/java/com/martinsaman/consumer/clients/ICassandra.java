package com.martinsaman.consumer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "CassandraClient", url = "localhost:3011/persona")
public interface ICassandra {

    @GetMapping
    public ResponseEntity<List<Object>> findAll();

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Object persona);

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Object persona);

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Object persona);
}

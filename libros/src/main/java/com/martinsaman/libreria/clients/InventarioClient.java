package com.martinsaman.libreria.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventarioClient",url = "localhost:2021")
public interface InventarioClient {
}

package com.martinsaman.libreria.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ventaClient",url = "localhost:2022")
public interface VentaClient {

}

# Dia 1

#### Domain Driven Design

* [Domain Driven Design](https://es.slideshare.net/baejjae93/domain-driven-design-37608771)
* [Domain Driven Design](https://medium.com/design-and-tech-co/implementing-domain-driven-design-for-microservice-architecture-26eb0333d72e)
* [Tecnicas de aislamiento](https://microservices.io/patterns/)
* [DDD Medium](https://medium.com/@gsigety/domain-driven-design-spring-boot-kata-1-8a85034babec)

#### Microprofile vs Spring Boot
Depende de:
1. Tamaño del equipo
2. Tiempos de entrega
3. Naturaleza del proyecto

El teorema de la construcción de la pizza, 2 a 3 agile, 1 no es agile.
Permite la interacción Holística del equipo


### Alternativas a Spring Boot

* [Quarkus](https://quarkus.io/)
* [Helidon](https://helidon.io/#/)
* [Micronaut Framework](https://micronaut.io/)

## Monitoreo
> Lo que no se puede medir, no se puede controlar, lo que no se puede controlar no se puede administrar
>
![](https://camo.githubusercontent.com/3a4e42452a50e36d5f93458bf538c7fd7836782a/68747470733a2f2f70726f6d6574686575732e696f2f6173736574732f6172636869746563747572652e737667 "Arquitectura prometheus server")
### Librerias para Spring Boot
* [Spring Boot Actuator](https://www.baeldung.com/spring-boot-actuators)
* [Micrometer](https://www.baeldung.com/micrometer)
* [Micrometer Prometheus](https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/)

######pom.xml
```maven
<!-- actuator -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<!-- Micrometer core dependecy  -->
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-core</artifactId>
</dependency>
<!-- Micrometer Prometheus registry  -->
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```
#Tarea
Investigar cómo exponer métricas en nuestro microservicio basado en los exporters, en nuestro actuator de spring boot

###Ayuda
* [Monitoring Spring Boot Apps with Micrometer, Prometheus, and Grafana](https://stackabuse.com/monitoring-spring-boot-apps-with-micrometer-prometheus-and-grafana/)
* [Prometheus y exporters](https://prometheus.io/download/)

####Notas
* .jar de SpringBoot pesa 10mb
* [Endpoint Actuator SpringBoot](http://localhost:8081/actuator/health)
* [Actuator .exe graph](http://localhost:9090/graph)
* [Actuator .exe targets](http://localhost:9090/targets)
* metrica -> execute






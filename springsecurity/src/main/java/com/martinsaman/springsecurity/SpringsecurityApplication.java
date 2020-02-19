package com.martinsaman.springsecurity;

import com.martinsaman.springsecurity.persistence.IPersona;
import com.martinsaman.springsecurity.persistence.Persona;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(IPersona repo) {
        return args -> {
            repo.save(new Persona("martin", "saman arata", "72720455", Boolean.TRUE));
            repo.save(new Persona("J", "Pacheco", "12345678", Boolean.TRUE));
        };
    }
}

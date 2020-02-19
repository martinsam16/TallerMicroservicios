package com.martinsaman.springsecurity.config;

import com.martinsaman.springsecurity.persistence.IPersona;
import com.martinsaman.springsecurity.persistence.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private IPersona repo;

    @Override
    public UserDetails loadUserByUsername(String dnipersona) throws UsernameNotFoundException {
        System.out.println("validando!");
        Optional<Persona> persona = repo.findPersonaByDni(dnipersona);
        User.UserBuilder builder = null;
        if (persona.isPresent()) {
            builder = User.withUsername(persona.get().getDni())
                    .password("{noop}" + persona.get().getDni())
                    .roles(persona.get().getIsUser() ? "USER" : "ADMIN")
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false);

        } else {
            System.out.println("gg :C");
            throw new UsernameNotFoundException("No existe en la db xd");
        }
        System.out.println(builder.build());
        return builder.build();
    }
}

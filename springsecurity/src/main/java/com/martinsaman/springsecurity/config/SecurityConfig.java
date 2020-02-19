package com.martinsaman.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImp detailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/persona/**").hasRole("USER")

                .antMatchers(HttpMethod.POST, "/persona/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/persona/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/persona/**").hasRole("ADMIN")
                .and()
                .userDetailsService(detailsService) //justo y necesario
                .csrf().disable()
                .formLogin().disable();
    }


    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
        auth.userDetailsService(detailsService); //porsiaca xdxd
    }


}

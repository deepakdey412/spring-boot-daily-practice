package com.SpringSecurityCustomConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    // This class contains our Spring Security configuration.
    // @Configuration → tells Spring this class provides configuration.
    // @EnableWebSecurity → enables Spring Security for the application.

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // This method defines the security filter chain (rules for authentication & authorization).
        // @Bean → Spring will create and manage this object.

        httpSecurity
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("register","login").permitAll()//it disable authentication for register endpoint and rest of the request will be scaned
                        .anyRequest().authenticated())
                // Rule: All requests must be authenticated (user must be logged in).

                .httpBasic(Customizer.withDefaults())
                // Enable HTTP Basic Authentication (popup for username/password).

                .csrf(csrf -> csrf.disable());
        // Disable CSRF protection (only for testing; in production keep it enabled).

        return httpSecurity.build();
        // Build and return the SecurityFilterChain object.
    }

    @Bean
    //this bean if only for practicing purpose , in real project we have to connect with actual db
    public UserDetailsService userDetailsService(){
        // This method creates a user details service that stores user data in memory.
        // In real projects, this will be connected to a database.

        UserDetails Deepak
                = User.withUsername("Deepak")
                // Set username: Deepak
                .password("{noop}Deepak123")
                // Set password: Deepak123
                // {noop} means no password encryption (only for testing).
                .roles("USER")
                // Assign role: USER (Spring will store it as ROLE_USER internally).
                .build();
        // Build the user object.

        UserDetails Devika
                = User.withUsername("Devika")
                .password("{noop}Devika123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(Deepak, Devika);
        // Store both users in memory using InMemoryUserDetailsManager.
        // This is only for testing; no database is used here.
    }


}

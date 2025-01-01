package com.capybytes.reimbursement_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for development purposes
                .authorizeRequests()
                .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Allow unauthenticated access to these endpoints
                .anyRequest().authenticated() // Require authentication for all other endpoints
                .and()
                .httpBasic(); // Enable basic authentication for other endpoints

        return http.build();
    }
}
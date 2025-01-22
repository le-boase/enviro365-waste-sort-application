package com.enviro.assessment.grad001.LesegoBoase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable security for all endpoints
        http.csrf().disable()
                .authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }
}

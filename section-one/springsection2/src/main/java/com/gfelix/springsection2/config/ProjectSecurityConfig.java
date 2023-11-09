package com.gfelix.springsection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
            .requestMatchers("/contact", "/notices").permitAll());
        http.formLogin();
        http.httpBasic();
        return http.build();
        
        // http.authorizeHttpRequests((requests) -> requests
        //         .anyRequest().denyAll());
        // http.formLogin();
        // http.httpBasic();
        // return http.build();

        
        // http.authorizeHttpRequests((requests) -> requests
        //         .anyRequest().permitAll());
        // http.formLogin();
        // http.httpBasic();
        // return http.build();
    }
    
}

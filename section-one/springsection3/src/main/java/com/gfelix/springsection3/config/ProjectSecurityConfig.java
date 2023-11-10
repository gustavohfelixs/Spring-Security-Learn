package com.gfelix.springsection3.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
            .requestMatchers("/contact", "/notices").permitAll());
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // @Bean
    // public InMemoryUserDetailsManager  detailsManager () {
    //     UserDetails admin = User.withDefaultPasswordEncoder()
    //         .username("admin")
    //         .password("12345")
    //         .authorities("admin")
    //         .build();
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("user")
    //         .password("12345")
    //         .authorities("user")
    //         .build();
    //     return new InMemoryUserDetailsManager(admin, user);
    // }
    
}
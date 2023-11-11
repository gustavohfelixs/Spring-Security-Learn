package com.gfelix.springsection3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gfelix.springsection3.repository.CustomerRepository;
import com.gfelix.springsection3.service.CustomerService;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
            .requestMatchers("/contact", "/notices", "/register").permitAll());
        http.csrf(csrf -> csrf.disable());
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(CustomerRepository repository) {
        return new CustomerService(repository);
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

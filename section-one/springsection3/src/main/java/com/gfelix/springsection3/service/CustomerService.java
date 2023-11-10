package com.gfelix.springsection3.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.gfelix.springsection3.domain.Customer;
import com.gfelix.springsection3.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<Customer> customers = repository.findByEmail(username);

        return customers.stream()
                .findFirst().map(customer -> {
                    var password = customer.getPwd();
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority(customer.getRole()));
                    return new User(username, password, authorities);
                })
            .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username));
    }
}

package com.gfelix.springsection3.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gfelix.springsection3.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider{

    private final CustomerRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var username = authentication.getName();
        var pwd = authentication.getCredentials().toString();
        var customers = repository.findByEmail(username);

        return customers.stream()
            .findFirst()
            .map(customer -> {
                if (encoder.matches(pwd, customer.getPwd())) {
                    List<GrantedAuthority> authorities = new ArrayList();
                    authorities.add(new SimpleGrantedAuthority(customer.getRole()));
                    return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
                } else {
                    throw new BadCredentialsException("Invalid Password for user");
                }
            })
            .orElseThrow(() -> new BadCredentialsException("User not registered"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
    
}

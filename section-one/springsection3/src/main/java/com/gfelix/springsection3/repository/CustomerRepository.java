package com.gfelix.springsection3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gfelix.springsection3.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> findByEmail(String email);

}

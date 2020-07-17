package com.demo.tdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.tdd.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	Customer findByUsername(String username);
}

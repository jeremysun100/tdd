package com.demo.tdd.services;

import com.demo.tdd.model.Customer;

public interface CustomerService {

	Customer getCustomerByUsername(String username);

	Customer createCustomer(Customer customer);
}

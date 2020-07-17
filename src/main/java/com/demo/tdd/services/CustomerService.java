package com.demo.tdd.services;

import com.demo.tdd.model.Customer;
import com.demo.tdd.model.MACustomer;

public interface CustomerService {

	MACustomer getMACustomerByUsername(String username);

	Customer createCustomer(Customer customer);
}

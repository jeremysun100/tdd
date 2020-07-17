package com.demo.tdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tdd.model.Customer;
import com.demo.tdd.model.MACustomer;
import com.demo.tdd.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("customers/{username}")
	public MACustomer getMACustomer(@PathVariable String username) {
		return customerService.getMACustomerByUsername(username);
	}

	@PostMapping("customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
}

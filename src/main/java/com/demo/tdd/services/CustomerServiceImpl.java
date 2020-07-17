package com.demo.tdd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.tdd.model.Customer;
import com.demo.tdd.model.MACustomer;
import com.demo.tdd.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public MACustomer getMACustomerByUsername(String username) {
		if (username.isBlank()) {
			throw new IllegalArgumentException();
		}
		Customer customer = customerRepository.findByUsername(username);
		MACustomer maCustomer = new MACustomer();
		maCustomer.setUsername(customer.getUsername());
		maCustomer.setFirstName(customer.getFirstName());
		maCustomer.setLastName(customer.getLastName());
		maCustomer.setGender(customer.getGender());
		if (customer.getGender().equals("M")) {
			maCustomer.setDisplayName(String.format("%s %s %s", "Mr.", customer.getFirstName(), customer.getLastName()));
		} else {
			maCustomer.setDisplayName(String.format("%s %s %s", "Mrs.", customer.getFirstName(), customer.getLastName()));
		}
		return maCustomer;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}

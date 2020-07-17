package com.demo.tdd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.tdd.model.Customer;
import com.demo.tdd.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomerByUsername(String username) {
		if (username.isBlank()) {
			throw new IllegalArgumentException();
		}
		Customer customer = customerRepository.findByUsername(username);
		if (customer.getGender().equals("M")) {
			customer.setDisplayName(String.format("%s %s %s", "Mr.", customer.getFirstName(), customer.getLastName()));
		} else {
			customer.setDisplayName(String.format("%s %s %s", "Mrs.", customer.getFirstName(), customer.getLastName()));
		}
		return customer;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}

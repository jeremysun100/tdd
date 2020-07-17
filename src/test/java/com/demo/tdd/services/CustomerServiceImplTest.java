package com.demo.tdd.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import com.demo.tdd.model.Customer;
import com.demo.tdd.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Test
	public void test_MaleCustomer() {
		when(customerRepository.findByUsername("jeremysun")).thenReturn(new Customer("jeremysun", "Jeremy", "Sun", "M", null));
		Customer maCustomer = customerService.getCustomerByUsername("jeremysun");
		assertThat(maCustomer.getUsername()).isEqualTo("jeremysun");
		assertThat(maCustomer.getFirstName()).isEqualTo("Jeremy");
		assertThat(maCustomer.getLastName()).isEqualTo("Sun");
		assertThat(maCustomer.getGender()).isEqualTo("M");
		assertThat(maCustomer.getDisplayName()).isEqualTo("Mr. Jeremy Sun");
	}

	@Test
	public void test_femaleCustomer() {
		when(customerRepository.findByUsername("janedoe")).thenReturn(new Customer("janedoe", "Jane", "Doe", "F", null));
		Customer customer = customerService.getCustomerByUsername("janedoe");
		assertThat(customer.getDisplayName()).isEqualTo("Mrs. Jane Doe");
	}

}

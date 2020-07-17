package com.demo.tdd.services;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.tdd.model.Customer;
import com.demo.tdd.model.MACustomer;
import com.demo.tdd.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Test
	public void test_MaleCustomer() {
		when(customerRepository.findByUsername("jeremysun")).thenReturn(new Customer("jeremysun", "Jeremy", "Sun", "M"));
		MACustomer maCustomer = customerService.getMACustomerByUsername("jeremysun");
		assertThat(maCustomer.getUsername()).isEqualTo("jeremysun");
		assertThat(maCustomer.getFirstName()).isEqualTo("Jeremy");
		assertThat(maCustomer.getLastName()).isEqualTo("Sun");
		assertThat(maCustomer.getGender()).isEqualTo("M");
		assertThat(maCustomer.getDisplayName()).isEqualTo("Mr. Jeremy Sun");
	}

	@Test
	public void test_femaleCustomer() {
		when(customerRepository.findByUsername("janedoe")).thenReturn(new Customer("janedoe", "Jane", "Doe", "F"));
		MACustomer maCustomer = customerService.getMACustomerByUsername("janedoe");
		assertThat(maCustomer.getDisplayName()).isEqualTo("Mrs. Jane Doe");
	}

}

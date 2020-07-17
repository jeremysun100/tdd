package com.demo.tdd.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.tdd.model.Customer;
import com.demo.tdd.services.CustomerService;

@WebMvcTest
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void testOK() {
		when(customerService.getCustomerByUsername("jeremysun")).thenReturn(new Customer("jeremysun", "Jeremy", "Sun", "M", "Mr. Jeremy Sun"));
		Customer customer = customerService.getCustomerByUsername("jeremysun");
		assertThat(customer.getFirstName()).isEqualTo("Jeremy");
	}
}

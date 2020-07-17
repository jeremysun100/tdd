package com.demo.tdd.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.tdd.model.MACustomer;
import com.demo.tdd.services.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void testOK() {
		when(customerService.getMACustomerByUsername("jeremysun")).thenReturn(new MACustomer("jeremysun", "Jeremy", "Sun", "M", "Mr. Jeremy Sun"));
		MACustomer maCustomer = customerService.getMACustomerByUsername("jeremysun");
		assertThat(maCustomer.getFirstName()).isEqualTo("Jeremy");
	}
}

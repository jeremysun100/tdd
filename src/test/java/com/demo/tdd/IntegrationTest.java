package com.demo.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.demo.tdd.model.Customer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testOK() {
		restTemplate.postForEntity("/customers", new Customer("jeremysun", "Jeremy", "Sun", "M", null), Customer.class);
		ResponseEntity<Customer> response = restTemplate.getForEntity("/customers/jeremysun", Customer.class);
		assertThat(response.getBody().getUsername()).isEqualTo("jeremysun");
	}
}

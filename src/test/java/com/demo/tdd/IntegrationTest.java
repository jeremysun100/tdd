package com.demo.tdd;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.model.Customer;
import com.demo.tdd.model.MACustomer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testOK() {
		restTemplate.postForEntity("/customers", new Customer("jeremysun", "Jeremy", "Sun", "M"), Customer.class);
		ResponseEntity<MACustomer> response = restTemplate.getForEntity("/customers/jeremysun", MACustomer.class);
		assertThat(response.getBody().getUsername()).isEqualTo("jeremysun");
	}
}

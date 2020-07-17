package com.demo.tdd.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testOK() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"username\": \"jeremysun\", \"firstName\": \"Jeremy\", \"lastName\": \"Sun\", \"gender\": \"M\" }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		mockMvc.perform(MockMvcRequestBuilders.get("/customers/jeremysun"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("username").value("jeremysun"));
	}
}

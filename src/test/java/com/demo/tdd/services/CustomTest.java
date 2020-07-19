package com.demo.tdd.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomTest {

	@Test
	void testFunc() {
		CustomServiceImpl customService = new CustomServiceImpl();
		assertThat(customService.echo("echo")).isEqualTo("echo");
	}
}

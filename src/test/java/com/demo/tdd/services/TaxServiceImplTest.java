package com.demo.tdd.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaxServiceImplTest {

	private TaxService taxService = new TaxServiceImpl();

	@Test
	void test_0() {
		assertEquals(0, taxService.getIncomeTax(0));
	}

	@Test
	void test_50k() {
		assertEquals(5000, taxService.getIncomeTax(50000));
	}

	@Test
	void test_100k() {
		assertEquals(15000, taxService.getIncomeTax(100000));
	}

	@Test
	void test_200k() {
		assertEquals(40000, taxService.getIncomeTax(200000));
	}

	@Test
	void test_invalid() {
		assertEquals(0, taxService.getIncomeTax(-1));
	}

}
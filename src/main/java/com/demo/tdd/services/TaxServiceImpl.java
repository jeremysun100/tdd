package com.demo.tdd.services;

public class TaxServiceImpl implements TaxService {
	@Override
	public int getIncomeTax(int income) {
		if (income <= 0) {
			return 0;
		} else if (income <= 50000) {
			return Math.round(income * 0.1f);
		} else if (income <= 100000) {
			return Math.round(5000 + (income - 50000) * 0.2f);
		} else {
			return Math.round(15000 + (income - 100000) * 0.25f);
		}
	}
}

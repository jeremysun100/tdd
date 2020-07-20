package com.demo.tdd.services;

public class TaxServiceImpl implements TaxService {
	@Override
	public int getIncomeTax(int income) {
		int tax;
		if (income <= 0) {
			tax = 0;
		} else if (income <= 50000) {
			tax = (int)Math.round(50000 * 0.1f);
		} else if (income <= 100000) {
			tax =  (int)Math.round(5000 + (income - 50000) * 0.2f);
		} else {
			tax = (int)Math.round(15000 + (income - 100000) * 0.25f);
		}
		return tax;
	}
}
